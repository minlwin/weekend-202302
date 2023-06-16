package com.jdc.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.registration.service.CourseService;
import com.jdc.registration.service.SectionService;

@Controller
@RequestMapping("public")
public class PublicHomeController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private SectionService sectionService;

	@GetMapping("home")
	String index(ModelMap model) {
		
		// All Courses
		model.put("courses", courseService.findAll());
		
		// Available Classes
		model.put("classes", sectionService.getAvailables());
		
		return "home";
	}

}
