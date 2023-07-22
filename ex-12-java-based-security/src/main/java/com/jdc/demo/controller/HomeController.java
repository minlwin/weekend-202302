package com.jdc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	String index() {
		return "home";
	}
	
	@GetMapping("/403")
	String accessDenied(ModelMap model) {
		model.put("message", "You have no permission to access previous request.");
		return "home";
	}
	
}
