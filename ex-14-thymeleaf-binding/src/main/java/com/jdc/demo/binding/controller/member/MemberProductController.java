package com.jdc.demo.binding.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.demo.binding.domain.dto.form.ProductForm;
import com.jdc.demo.binding.domain.entity.Feature;
import com.jdc.demo.binding.domain.service.ShopService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member/product")
@RequiredArgsConstructor
public class MemberProductController {
	
	private final ShopService shopService;
	
	@GetMapping("{id}")
	public String findById(@PathVariable int id) {
		return "member/product/details";
	}

	@GetMapping("edit")
	public String edit(@RequestParam int shop, ModelMap model) {
		
		model.put("shopInfo", shopService.findInformation(shop));
		
		return "member/product/edit";
	}
	
	@PostMapping("edit")
	public String save(
			@Validated @ModelAttribute("form") ProductForm form, BindingResult bindingResult,
			ModelMap model, @RequestParam int addFeature, @RequestParam int deleteIndex) {
		
		if(bindingResult.hasErrors()) {
			model.put("shopInfo", shopService.findInformation(form.getShop()));
			return "member/product/edit";
		}
		
		if(addFeature > 0) {
			form.getFeatures().add(new Feature());
			model.put("shopInfo", shopService.findInformation(form.getShop()));
			return "member/product/edit";
		}
		
		if(deleteIndex >= 0) {
			form.getFeatures().remove(deleteIndex);
			model.put("shopInfo", shopService.findInformation(form.getShop()));
			return "member/product/edit";
		}
		
		return "redirect:/member/product/%d".formatted(1);
	}
	
	@ModelAttribute("form")
	public ProductForm form(@RequestParam int shop) {
		var form = new ProductForm();
		form.setShop(shop);
		form.getFeatures().add(new Feature());
		return form;
	}
}
