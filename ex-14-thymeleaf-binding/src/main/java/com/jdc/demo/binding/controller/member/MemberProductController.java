package com.jdc.demo.binding.controller.member;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.demo.binding.domain.dto.form.FeatureForm;
import com.jdc.demo.binding.domain.dto.form.ProductForm;
import com.jdc.demo.binding.domain.service.ProductService;
import com.jdc.demo.binding.domain.service.ShopService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member/product")
@RequiredArgsConstructor
public class MemberProductController {
	
	private final ShopService shopService;
	private final ProductService productService;
	
	@GetMapping("edit")
	public String edit(@RequestParam int shop, @RequestParam("id") Optional<Integer> productId, ModelMap model) {
		
		model.put("shopInfo", shopService.findInformation(shop));
		
		return "member/product/edit";
	}
	
	@PostMapping("edit")
	public String save(
			@Validated @ModelAttribute("form") ProductForm form, BindingResult bindingResult,
			ModelMap model, @RequestParam int addFeature, @RequestParam int deleteIndex) {
		
		if(addFeature > 0) {
			form.getFeatures().add(new FeatureForm());
			model.remove("org.springframework.validation.BindingResult.form");
			model.put("shopInfo", shopService.findInformation(form.getShop()));
			return "member/product/edit";
		}
		
		if(deleteIndex >= 0) {
			form.getFeatures().remove(deleteIndex);
			model.remove("org.springframework.validation.BindingResult.form");
			model.put("shopInfo", shopService.findInformation(form.getShop()));
			return "member/product/edit";
		}
		
		if(bindingResult.hasErrors()) {
			model.put("shopInfo", shopService.findInformation(form.getShop()));
			return "member/product/edit";
		}
		
		var id = productService.save(form);
		
		return "redirect:/public/product/%d".formatted(id);
	}
	
	@ModelAttribute("form")
	public ProductForm form(@RequestParam int shop, @RequestParam("id") Optional<Integer> productId) {
		return productId.filter(a -> a > 0).map(id -> productService.getFormById(id)).orElseGet(() -> {
			var form = new ProductForm();
			form.setShop(shop);
			return form;
		});
	}
}
