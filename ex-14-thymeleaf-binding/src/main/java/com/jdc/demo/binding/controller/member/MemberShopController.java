package com.jdc.demo.binding.controller.member;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.demo.binding.domain.dto.form.ShopForm;
import com.jdc.demo.binding.domain.service.ShopService;

@Controller
@RequestMapping("member/shop")
public class MemberShopController {
	
	@Autowired
	private ShopService service;

	@GetMapping("edit")
	public String edit() {
		return "member/shop/edit";
	}
	
	@PostMapping("edit")
	public String save(@Validated @ModelAttribute("form") ShopForm form, BindingResult result) {
		return "";
	}
	
	@ModelAttribute("form")
	public ShopForm form(@RequestParam Optional<Integer> id) {
		return id.filter(a -> a > 0)
				.map(a -> service.findFormById(a))
				.orElse(new ShopForm());
	}
}
