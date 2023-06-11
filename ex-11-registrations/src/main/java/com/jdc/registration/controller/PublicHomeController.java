package com.jdc.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("public/home")
public class PublicHomeController {

	@GetMapping
	String index() {
		return "home";
	}
}
