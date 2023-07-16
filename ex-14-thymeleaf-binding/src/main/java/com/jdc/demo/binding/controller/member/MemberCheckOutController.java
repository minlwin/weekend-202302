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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jdc.demo.binding.domain.dto.form.AddressForm;
import com.jdc.demo.binding.domain.service.AddressService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member/checkout")
@SessionAttributes(names = "shipping", types = AddressForm.class)
@RequiredArgsConstructor
public class MemberCheckOutController {
	
	private final AddressService addressService;

	/**
	 * Launch Check Out View
	 * @param model
	 * @return
	 */
	@GetMapping
	String index(ModelMap model) {
		model.put("addresses", addressService.findCustomerAddresses());
		return "invoice/shipping-address";
	}
	
	/**
	 * Select Existing Address
	 * @param id
	 * @return
	 */
	@PostMapping("address/{id}")
	String setAddress(@PathVariable int id, HttpSession session) {
		session.setAttribute("shipping", addressService.findFormById(id));
		return "redirect:/member/checkout/confirm";
	}
	
	/**
	 * Create New Address
	 * @param form
	 * @return
	 */
	@PostMapping("address")
	String setShippingAddress(
			@Validated @ModelAttribute AddressForm form, 
			BindingResult result,
			HttpSession session,
			ModelMap model) {
		
		if(result.hasErrors()) {
			model.put("addresses", addressService.findCustomerAddresses());
			return "invoice/shipping-addresses";
		}
		
		session.setAttribute("shipping", form);
		
		return "redirect:/member/checkout/confirm";
	}
	
	@GetMapping("confirm")
	String showConfirmInvoice() {
		return "invoice/confirm";
	}
	
	/**
	 * Check Out Operation
	 * @param form
	 * @return
	 */
	@PostMapping
	String checkOut(@SessionAttribute("shipping") AddressForm form) {
		return "";
	}
	
	@ModelAttribute("form")
	AddressForm form(@SessionAttribute(required = false, name = "shipping") AddressForm form) {
		return form != null ? form : new AddressForm();
	}
	
}
