package com.jdc.demo.binding.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.demo.binding.domain.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("public/product")
@RequiredArgsConstructor
public class PublicProductController {
	
	private final ProductService productService;

	@GetMapping("{id}")
	String showDetails(@PathVariable int id, ModelMap model) {
		var data = productService.findDetailsById(id).orElseThrow();
		model.put("data", data);
		model.put("owner", data.getShopOwner().equals(SecurityContextHolder.getContext().getAuthentication().getName()));
		return "member/product/details";
	}
}
