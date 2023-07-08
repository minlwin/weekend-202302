package com.jdc.demo.binding.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.demo.binding.domain.service.ProductService;
import com.jdc.demo.binding.domain.service.ShopService;

@Controller
@RequestMapping("public/shop")
public class PublicShopController {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private ProductService productService;

	@GetMapping
	public String index(@RequestParam Optional<String> keyword, ModelMap model) {
		model.put("list", shopService.search(keyword));
		return "public/shops";
	}
	
	@GetMapping("{id}")
	public String showDetails(@PathVariable int id, ModelMap model) {
		
		// Shop Information
		var shopInfo = shopService.findInformation(id);
		model.put("shopInfo", shopInfo);
		
		// Products of Shop
		model.put("products", productService.findByShop(id));
		
		// Is Owner
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		model.put("owner", shopInfo.getEmail().equals(username));
		
		return "public/shops-details";
	}
}
