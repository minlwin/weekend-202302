package com.jdc.demo.binding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.demo.binding.domain.repo.CategoryRepo;

@Controller
@RequestMapping("public/home")
public class HomeController {
	
	@Autowired
	private CategoryRepo repo;

	@GetMapping
	public String index(ModelMap model) {
		model.put("list", repo.findAll());
		return "public/home";
	}
}
