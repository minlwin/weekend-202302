package com.jdc.demo.binding.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.demo.binding.domain.service.ShopService;

@Controller
@RequestMapping("member/home")
public class MemberHomeController {
	
	@Autowired
	private ShopService shopService;

	@GetMapping
	public String index(ModelMap model) {
		
		// My Shops
		model.put("myShops", shopService.findOnerShops());
		
		// My Fav Shops
		
		// Top Customers
		
		return "member/home";
	}
}
