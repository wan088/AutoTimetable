package kr.or.connect.mvcexam.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

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
	static int condi;
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
			@RequestParam(name="condi", required=true)int conded,
			HttpServletRequest rq,
			ModelMap model) {
		condi=conded;
		HttpSession sess = rq.getSession();
		Map<String, List> gangMap = (Map)sess.getAttribute("map");
		List<List> answerList = func(gangMap);
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
	
	public void Go(Map<String, List> gangMap, int depth, Object[] keyArray, List<gang> tmpList, List answerList) {
		if(depth==keyArray.length) {
			if(isFitted(tmpList)) {
				//answer.addAll(tmpList);
				List<List> answer = new LinkedList<>();
				for(gang gang : tmpList) {
					List<gang2> newList=gangToList(gang);
					answer.add(newList);
				}
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
		return tt.isFittedTable(tmpList, condi);
	}
	public class gang2{
		int yoil;
		int start;
		int len;
		String number;
		String name;
		public gang2(int yoil, int start, int len, String name, String number) {
			this.yoil=yoil; this.start=start; this.len=len; this.name=name; this.number=number;
		}
		public int getYoil() {
			return yoil;
		}
		public void setYoil(int yoil) {
			this.yoil = yoil;
		}
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getLen() {
			return len;
		}
		public void setLen(int len) {
			this.len = len;
		}
		public String getName() {
			return name;
		}
		public String getNumber() {
			return number;
		}
		
	}
	public List<gang2> gangToList(gang tmpGang) {
		List list = new LinkedList();
		StringTokenizer st = new StringTokenizer(tmpGang.getTimes(), "/");
		while(st.hasMoreTokens()) {
			String name = tmpGang.getName();
			String number = tmpGang.getNumber();
			String times= st.nextToken();
			int yoil = getYoil(times.charAt(0));
			times=times.substring(1);
			StringTokenizer st2 = new StringTokenizer(times, "-");
			int start = (int)(Double.parseDouble(st2.nextToken())*2);
			int len = (int)(Double.parseDouble(st2.nextToken())*2)-start+1;
			gang2 tmpGang2= new gang2(yoil, start, len, name, number);
			list.add(tmpGang2);
		}
		return list;
	}
	public int getYoil(char c) {
		if(c=='월')
			return 0;
		else if(c=='화')
			return 1;
		else if(c=='수')
			return 2;
		else if(c=='목')
			return 3;
		else if(c=='금')
			return 4;
		else
			return -1;	
	}
}



