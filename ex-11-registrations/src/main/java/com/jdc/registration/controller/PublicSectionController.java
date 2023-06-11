package com.jdc.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("public/section")
public class PublicSectionController {

	@GetMapping
	String showSections() {
		return "section/list";
	}
	
	@GetMapping("{id}")
	String showSectionDetails() {
		return "section/details";
	}
}
