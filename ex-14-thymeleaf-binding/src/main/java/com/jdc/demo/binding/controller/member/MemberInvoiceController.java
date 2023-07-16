package com.jdc.demo.binding.controller.member;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.demo.binding.domain.service.InvoiceService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member/invoice")
@RequiredArgsConstructor
public class MemberInvoiceController {
	
	private final InvoiceService invoiceService;
	
	@GetMapping("sales")
	String searchSales(ModelMap model,
			@RequestParam Optional<Integer> shop, 
			@RequestParam Optional<LocalDate> from,
			@RequestParam Optional<LocalDate> to) {
		model.put("list", invoiceService.searchSales(shop, from, to));
		return "member/sales";
	}
	
	@GetMapping("orders")
	String searchOrders(ModelMap model,
			@RequestParam Optional<LocalDate> from,
			@RequestParam Optional<LocalDate> to) {
		model.put("list", invoiceService.searchOrders(from, to));
		return "member/purchases";
	}

	@GetMapping("sales/{id}")
	String showSalesDetails(ModelMap model, @PathVariable int id) {
		model.put("data", invoiceService.findDetailsForShop(id));
		return "invoice/details";
	}

	@GetMapping("orders/{id}")
	String showOrdersDetails(ModelMap model, @PathVariable int id) {
		model.put("data", invoiceService.findDetailsForCustomer(id));
		return "invoice/details";
	}
}
