package com.jdc.demo.binding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("public/shop")
public class PublicShopController {

	@GetMapping
	public String index() {
		return "public/shops";
	}
	
	@GetMapping("{id}")
	public String showDetails(@PathVariable int id) {
		return "public/shops-details";
	}
}
