package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
			@RequestParam(name = "searchClass", required=true) String value1,
			ModelMap modelMap) {
		modelMap.addAttribute("value3", value1);
		return "test";
	}
}
