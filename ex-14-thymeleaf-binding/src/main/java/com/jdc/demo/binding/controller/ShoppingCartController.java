package com.jdc.demo.binding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("public/cart")
public class ShoppingCartController {

	@GetMapping
	public String index() {
		return "public/cart";
	}
}
