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

import com.jdc.demo.binding.domain.dto.form.AddressForm;
import com.jdc.demo.binding.domain.service.AddressService;
import com.jdc.demo.binding.domain.service.InvoiceService;
import com.jdc.demo.binding.domain.service.ShoppingCart;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member/checkout")
@RequiredArgsConstructor
public class MemberCheckOutController {
	
	private final AddressService addressService;
	private final InvoiceService invoiceService;
	private final ShoppingCart cart;

	/**
	 * Launch Check Out View
	 * @param model
	 * @return
	 */
	@GetMapping
	String index(ModelMap model, HttpSession session) {
		var addresses = addressService.findCustomerAddresses();
		model.put("addresses", addresses);
		
		if(!addresses.isEmpty() && session.getAttribute("shipping") == null) {
			session.setAttribute("shipping", addresses.get(0));
		}
		
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
	String setNewAddress(
			@Validated @ModelAttribute("form") AddressForm form, 
			BindingResult result,
			HttpSession session,
			ModelMap model) {
		
		if(result.hasErrors()) {
			var addresses = addressService.findCustomerAddresses();
			model.put("addresses", addresses);
			
			if(!addresses.isEmpty() && session.getAttribute("shipping") == null) {
				session.setAttribute("shipping", addresses.get(0));
			}

			return "invoice/shipping-address";
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
		var invoiceId = invoiceService.invoice(form, cart.getItems());
		cart.clear();
		return "redirect:/member/invoice/%d".formatted(invoiceId);
	}
	
	@ModelAttribute("form")
	AddressForm form() {
		return new AddressForm();
	}
	
}
