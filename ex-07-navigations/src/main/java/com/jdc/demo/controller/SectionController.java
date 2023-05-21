package com.jdc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("section")
public class SectionController {

	@GetMapping
	String index() {
		return "section";
	}
	
	@GetMapping("edit")
	String edit() {
		return "section-edit";
	}
	
	@GetMapping("{id}")
	String showDetails() {
		return "section-details";
	}
}
