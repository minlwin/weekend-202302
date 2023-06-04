package com.jdc.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("office/account")
public class AccountController {

	@GetMapping
	String index() {
		return "account/list";
	}
	
	@GetMapping("edit")
	String edit() {
		return "account/edit";
	}
	
	@PostMapping
	String save() {
		return "redirect:/office/account";
	}
}
