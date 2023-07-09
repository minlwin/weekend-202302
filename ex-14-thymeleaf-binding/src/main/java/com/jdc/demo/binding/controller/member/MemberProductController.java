package com.jdc.demo.binding.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.demo.binding.domain.dto.form.ProductForm;

@Controller
@RequestMapping("member/product")
public class MemberProductController {
	
	@GetMapping("{id}")
	public String findById(@PathVariable int id) {
		return "member/product/details";
	}

	@GetMapping("edit")
	public String edit(@RequestParam int shop) {
		return "member/product/edit";
	}
	
	@PostMapping("edit")
	public String save(@Validated @ModelAttribute("form") ProductForm form,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "member/product/edit";
		}
		
		return "redirect:/member/product/%d".formatted(1);
	}
	
	@ModelAttribute("form")
	public ProductForm form(@RequestParam int shop) {
		var form = new ProductForm();
		form.setShop(shop);
		return form;
	}
}
