package com.jdc.registration.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.registration.service.AccountService;
import com.jdc.registration.service.CourseService;
import com.jdc.registration.service.RegistrationService;
import com.jdc.registration.service.entity.Account.Role;

@Controller
@RequestMapping(value = "office/registration")
public class OfficeRegistrationController {
	
	@Autowired
	private RegistrationService service;
	@Autowired
	private CourseService courseService;
	@Autowired
	private AccountService accountService;
	
	@GetMapping
	String search(
			@RequestParam Optional<Integer> course,
			@RequestParam Optional<Integer> teacher,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> from,
			ModelMap model) {
		
		model.put("courses", courseService.findAll());
		model.put("teachers", accountService.search(Optional.of(Role.Teacher), Optional.empty()));
		
		model.put("list", service.search(course, teacher, from));
		
		return "registration/list";
	}

}
