package com.jdc.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.demo.entity.Company;
import com.jdc.demo.service.CompanyService;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private CompanyService service;

	@GetMapping
	String index(ModelMap model) {
		model.put("title", "Company Management");
		model.put("message", "You can manage compnies with this view.");
		model.put("list", service.findAll());
		return "home";
	}
	
	@GetMapping("edit")
	String edit() {
		return "company-edit";
	}
	
	@PostMapping("edit")
	String save(@ModelAttribute("form") @Validated Company form, BindingResult result) {
		
		if(result.hasErrors()) {
			return "company-edit";
		}
		
		service.save(form);
		
		return "redirect:/home";
	}
	
	@ModelAttribute("form")
	Company form() {
		var company = new Company();
		company.setPhone(new ArrayList<>());
		return company;
	}
}
