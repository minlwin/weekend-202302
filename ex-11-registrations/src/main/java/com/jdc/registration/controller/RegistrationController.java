package com.jdc.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("registration")
public class RegistrationController {

	@GetMapping
	String edit() {
		return "registration/edit";
	}
	
	@PostMapping
	String save() {
		return "redirect:/student/section";
	}
}
