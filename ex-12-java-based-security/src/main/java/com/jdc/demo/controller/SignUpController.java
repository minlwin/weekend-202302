package com.jdc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.demo.controller.form.SignUpForm;
import com.jdc.demo.entity.Account.Role;
import com.jdc.demo.service.SignUpService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("signup")
public class SignUpController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private SecurityContextRepository securityContextRepository;

	@Autowired
	private SignUpService service;
	
	@GetMapping
	String index() {
		return "signup";
	}
	
	@PostMapping
	String signUp(
			@Validated @ModelAttribute("form") SignUpForm form, 
			BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {
		
		if(result.hasErrors()) {
			return "signup";
		}
		
		service.signUp(form);
		
		var auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(auth);
		securityContextRepository.saveContext(SecurityContextHolder.getContext(), request, response);
		
		return "redirect:/";
	}
	
	@ModelAttribute("roles")
	Role [] roles() {
		return Role.values();
	}
	
	@ModelAttribute("form") SignUpForm form() {
		return new SignUpForm();
	}
}
