package com.jdc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teacher")
public class TeacherController {

	@GetMapping
	String index() {
		return "teacher";
	}
	
	@GetMapping("{id}")
	String showDetails() {
		return "teacher-details";
	}
	
	@GetMapping("edit")
	String edit() {
		return "teacher-edit";
	}
}
