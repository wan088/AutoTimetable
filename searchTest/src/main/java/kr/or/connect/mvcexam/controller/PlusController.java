package kr.or.connect.mvcexam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		List<gang> list = gd.selectByName(value);
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
}



