package com.jdc.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("public/registration")
public class PublicRegistrationController {

	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("{sectionId}")
	String edit(@PathVariable int id, ModelMap model) {
		model.put("dto", sectionService.findById(id));
		return "registration/edit";
	}
	
	@PostMapping("{sectionId}")
	String save(@PathVariable int id, 
			@ModelAttribute("form") @Validated RegistrationForm form, BindingResult result, 
			ModelMap model) {
		
		if(result.hasErrors()) {
			model.put("dto", sectionService.findById(id));
			return "registration/edit";
		}
		
		registrationService.save(form);
		
		return "redirect:/member/home";
	}
	
	@ModelAttribute("form")
	RegistrationForm form(@PathVariable int id) {
		var form = new RegistrationForm();
		form.setSectionId(id);
		return form;
	}
}
