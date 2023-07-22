package com.jdc.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.registration.service.RegistrationService;
import com.jdc.registration.service.SectionService;
import com.jdc.registration.service.form.RegistrationForm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("public/registration")
public class PublicRegistrationController {

	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private SecurityContextRepository securityContextRepository;
	
	@GetMapping("{sectionId}")
	String edit(@PathVariable("sectionId") int id, ModelMap model) {
		model.put("dto", sectionService.findById(id));
		return "registration/edit";
	}
	
	@PostMapping("{sectionId}")
	String save(@PathVariable("sectionId") int id, 
			@ModelAttribute("form") @Validated RegistrationForm form, BindingResult result, 
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		if(result.hasErrors()) {
			model.put("dto", sectionService.findById(id));
			return "registration/edit";
		}
		
		// Register student to section
		registrationService.save(form);
		
		// Authenticate with Authentication Manager
		var authResult = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword()));
		
		// Set Authentication Result to Security Context
		SecurityContextHolder.getContext().setAuthentication(authResult);
		
		// Store SecurityContextHodler to SecurityContextRepository
		securityContextRepository.saveContext(SecurityContextHolder.getContext(), request, response);
		
		return "redirect:/member/home";
	}
	
	@ModelAttribute("form")
	RegistrationForm form(@PathVariable("sectionId") int id) {
		var form = new RegistrationForm();
		form.setSectionId(id);
		return form;
	}
}
