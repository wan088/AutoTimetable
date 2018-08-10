package kr.or.connect.mvcexam.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
