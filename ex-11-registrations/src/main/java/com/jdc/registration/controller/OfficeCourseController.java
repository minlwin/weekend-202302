package com.jdc.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.registration.service.CourseService;

@Controller
@RequestMapping("office/course")
public class OfficeCourseController {
	
	@Autowired
	private CourseService service;
	
	@GetMapping
	String index(ModelMap model) {
		model.put("list", service.findAll());
		return "course/list";
	}

	@GetMapping("edit")
	String edit() {
		
		return "course/edit";
	}
	
	@PostMapping
	String save() {
		return "redirect:/course";
	}
	

}
