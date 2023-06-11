package com.jdc.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("office/course")
public class OfficeCourseController {

	@GetMapping
	String edit() {
		return "course/edit";
	}
	
	@PostMapping
	String save() {
		return "redirect:/course";
	}
}
