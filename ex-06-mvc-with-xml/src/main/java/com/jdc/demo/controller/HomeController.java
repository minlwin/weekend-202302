package com.jdc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.demo.service.DaysOfWeekService;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private DaysOfWeekService service;

	@GetMapping
	String index(Model model) {
		var days = service.getAll();
		model.addAttribute("days", days);
		return "home";
	}
	
}
