package com.jdc.demo.binding.controller.member;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdc.demo.binding.domain.entity.Invoice.Status;
import com.jdc.demo.binding.domain.service.AccountService;
import com.jdc.demo.binding.domain.service.InvoiceService;
import com.jdc.demo.binding.domain.service.ShopService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member/invoice")
@RequiredArgsConstructor
public class MemberInvoiceController {
	
	private final InvoiceService invoiceService;
	private final ShopService shopService;
	private final AccountService accountService;
	
	@GetMapping("sales")
	String searchSales(ModelMap model,
			@RequestParam Optional<Integer> shop, 
			@RequestParam Optional<Status> status, 
			@RequestParam Optional<LocalDate> from,
			@RequestParam Optional<LocalDate> to) {
		
		// Status
		model.put("statusArray", Status.values());
		
		// Shop List
		model.put("shopList", shopService.findOnerShops());
		
		// Search Result
		model.put("list", invoiceService.searchSales(shop, status, from, to));
		return "member/sales";
	}
	
	@GetMapping("sales/customer")
	public String customerOrders(ModelMap model, @RequestParam String customer) {
		
		// Search Customer Information
		model.put("customer", accountService.findCustomerInformation(customer));
		
		// Search Result	
		model.put("list", invoiceService.searchSales(customer));
		return "member/customer-orders";
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
		return "invoice/details-for-shop";
	}	
	

	@GetMapping("orders/{id}")
	String showOrdersDetails(ModelMap model, @PathVariable int id) {
		model.put("data", invoiceService.findDetailsForCustomer(id));
		return "invoice/details-for-customer";
	}
}
