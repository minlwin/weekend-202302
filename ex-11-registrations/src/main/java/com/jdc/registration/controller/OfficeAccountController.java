package com.jdc.registration.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.registration.service.AccountService;
import com.jdc.registration.service.entity.Account.Role;
import com.jdc.registration.service.form.AccountForm;

@Controller
@RequestMapping("office/account")
public class OfficeAccountController {
	
	@Autowired
	private AccountService service;

	@GetMapping
	String index(
			@RequestParam Optional<Role> role,
			@RequestParam Optional<String> name,
			ModelMap model) {
		
		model.put("list", service.search(role, name));
		
		return "account/list";
	}
	
	@GetMapping("edit")
	String edit() {
		return "account/edit";
	}
	
	@PostMapping("edit")
	String save(@Validated @ModelAttribute("form") AccountForm form, 
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "account/edit";
		}
			
		service.save(form);
		
		return "redirect:/office/account";
	}
	
	@ModelAttribute("form")
	AccountForm form(@RequestParam Optional<Integer> id) {
		return id.filter(a -> a > 0).isEmpty() ? new AccountForm() : 
			service.getFormById(id.get());
	}
	
	@ModelAttribute("roles")
	Role [] roles() {
		return Role.values();
	}
}
