package com.jdc.demo.binding.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.demo.binding.domain.service.AccountService;
import com.jdc.demo.binding.domain.service.ShopService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("member/home")
public class MemberHomeController {
	
	private final ShopService shopService;
	private final AccountService accountService;
	
	@GetMapping
	public String index(ModelMap model) {
		
		var myShops = shopService.findOnerShops();
		// My Shops
		model.put("myShops", myShops);
		
		// My Fav Shops
		model.put("favShops", shopService.findFavShops());
		
		// Top Customers
		if(!myShops.isEmpty()) {
			model.put("topCustomers", accountService.findTopCustomers());
		}
		
		return "member/home";
	}
	
}
