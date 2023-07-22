package com.jdc.demo.binding.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.demo.binding.domain.entity.Category;
import com.jdc.demo.binding.domain.repo.CategoryRepo;
import com.jdc.demo.binding.domain.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("public/home")
@RequiredArgsConstructor
public class HomeController {
	
	private final CategoryRepo repo;
	private final ProductService service;

	@GetMapping
	public String index(
			@RequestParam Optional<Integer> category,
			@RequestParam Optional<String> keyword, 
			ModelMap model) {
		
		model.put("list", service.search(category, keyword));
		
		return "public/home";
	}
	
	@ModelAttribute("categories")
	public List<Category> categories() {
		return repo.findAll();
	}
}
