package com.jdc.registration.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("public/registration")
@PreAuthorize("isAnonymous or hasAuthority('Student')")
public class PublicRegistrationController {

	@GetMapping
	String edit() {
		return "registration/edit";
	}
	
	@PostMapping
	String save() {
		return "redirect:/student/section";
	}
}
