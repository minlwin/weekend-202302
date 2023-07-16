package com.jdc.demo.binding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.demo.binding.domain.dto.vo.PurchaseItemVO;
import com.jdc.demo.binding.domain.service.ProductService;
import com.jdc.demo.binding.domain.service.ShoppingCart;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("public/cart")
@RequiredArgsConstructor
public class ShoppingCartController {
	
	private final ShoppingCart cart;
	private final ProductService productService;
	
	@GetMapping
	String index(ModelMap model) {
		
		// Product Informations
		var purchaseItems = productService.getPurchaseItems(cart.getItems());
		model.put("items", purchaseItems);
		
		// Summary Informations
		var subTotal = purchaseItems.stream().mapToInt(PurchaseItemVO::getTotal).sum();
		cart.setSummary(subTotal);
		
		return "invoice/cart-view";
	}
	
	@PostMapping
	String addToCart(@RequestParam int productId, @RequestParam int count, @RequestParam(required = false, defaultValue = "false") Boolean cartView) {
		cart.addToCart(productId, count);
		if(cart.getCount() > 0) {
			return cartView ? "redirect:/public/cart" : "redirect:/public/product/%s".formatted(productId);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("clear")
	String clear() {
		return "redirect:/";
	}
}
