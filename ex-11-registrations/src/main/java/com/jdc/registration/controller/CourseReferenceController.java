package com.jdc.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("course")
public class CourseReferenceController {

	@GetMapping
	String index() {
		return "course/list";
	}
}
