package com.jdc.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teacher/section")
public class TeacherSectionController {
	
	@GetMapping
	String index() {
		return "my-sections";
	}	

	@GetMapping("edit")
	String edit() {
		return "section/edit";
	}
	
	@PostMapping
	String save() {
		return "redirect:/section/{id}";
	}
}
