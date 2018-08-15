package kr.or.connect.mvcexam.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.mvcexam.config.ApplicationConfig;
import kr.or.connect.mvcexam.dao.GangDao;
import kr.or.connect.mvcexam.dto.gang;
import kr.or.connect.mvcexam.frame.TimeTable;

@Controller
public class PlusController {
	@GetMapping(path="/plusform")
	public String plusform() {
		return "plusform";
	}
	@PostMapping(path="/plus")
	public String plus(
			@RequestParam(name = "value1", required=true) int value1
			,@RequestParam(name = "value2", required=true) int value2,
			ModelMap modelMap
			) {
		int answer= value1+value2;
		modelMap.addAttribute("value1", value1);
		modelMap.addAttribute("value2", value2);
		modelMap.addAttribute("answer", answer);
		return "plusResult";
	}
	@PostMapping(path="/search")
	public String search(
			@RequestParam(name = "searchClass", required=true) String value,
			ModelMap modelMap) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GangDao gd = ac.getBean(GangDao.class);
		List<gang> list =gd.selectByName(value);		
		modelMap.addAttribute("list", list);
		return "test";
	}
	
	@PostMapping(path="/register")
	public String register(
			@RequestBody String value,
			ModelMap modelMap,
			HttpServletRequest rq) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		/*String value = (String)valueMap.get("value");*/
		GangDao gd = ac.getBean(GangDao.class);
		List<gang> list = gd.selectByOnlyName(value);
		/*
		Map<String, List> gangMap = ac.getBean("gangMap", Map.class);
		*/
		HttpSession sess =rq.getSession();
		Map<String, List> gangMap = new HashMap<String, List>();
		if(sess.getAttribute("map")!=null) {
			gangMap = (Map)sess.getAttribute("map");
		}
		gangMap.put(value, list);
		sess.setAttribute("map", gangMap);		
		
		return "test2";
	}
	@PostMapping(path="/remove")
	public String remove(
			@RequestBody String value,
			ModelMap modelMap,
			HttpServletRequest rq) {
		HttpSession sess = rq.getSession();
		Map<String, List> gangMap = (Map)sess.getAttribute("map");
		gangMap.remove(value);
		
		return "test2";
		
	}
	@GetMapping(path="/make")
	public String make(
			@RequestParam(name="table", required=false, defaultValue="0")int table,
			HttpServletRequest rq,
			ModelMap model) {
		HttpSession sess = rq.getSession();
		Map<String, List> gangMap = (Map)sess.getAttribute("map");
		List<List> answerList = func(gangMap);
		
		for(List<gang> list :answerList) {
			for(gang gang : list) {
				System.out.println(gang.getNumber());
				System.out.println(gang.getTimes());
			}
			System.out.println("-");
		}
		model.addAttribute("timeTable", answerList.get(table));
		return "timeTable";
	}
	
	public List func(Map<String, List> gangMap) {
		Object[] keyArray=gangMap.keySet().toArray();
		List<gang> tmpList = new LinkedList<>();
		List<List> answerList = new LinkedList<>();
		Go(gangMap, 0, keyArray, tmpList, answerList);
		return answerList;
	}
	public void Go(Map<String, List> gangMap, int depth, Object[] keyArray, List tmpList, List answerList) {
		if(depth==keyArray.length) {
			if(isFitted(tmpList)) {
				answer.addAll(tmpList);
				
				List<gang2> answer = new LinkedList<>();
				answerList.add(answer);
			}
		}else {
			List<gang> list= gangMap.get((String)keyArray[depth]);
			for(gang gang:list) {
				tmpList.add(gang);
				Go(gangMap, depth+1, keyArray, tmpList, answerList);
				tmpList.remove(gang);
			}
		}
	}
	public boolean isFitted(List tmpList) {
		TimeTable tt = new TimeTable();
		return tt.isFittedTable(tmpList);
	}
	public class gang2{
		int yoil;
		int start;
		int end;
	}
}



