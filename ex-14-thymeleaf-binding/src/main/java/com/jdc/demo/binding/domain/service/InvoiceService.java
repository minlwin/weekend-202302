package com.jdc.demo.binding.domain.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.binding.domain.dto.form.AddressForm;
import com.jdc.demo.binding.domain.entity.Account;
import com.jdc.demo.binding.domain.entity.Address;
import com.jdc.demo.binding.domain.entity.Invoice;
import com.jdc.demo.binding.domain.entity.Invoice.Status;
import com.jdc.demo.binding.domain.entity.InvoiceItem;
import com.jdc.demo.binding.domain.entity.InvoiceShop;
import com.jdc.demo.binding.domain.entity.Shop;
import com.jdc.demo.binding.domain.repo.AccountRepo;
import com.jdc.demo.binding.domain.repo.AddressRepo;
import com.jdc.demo.binding.domain.repo.InvoiceRepo;
import com.jdc.demo.binding.domain.repo.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InvoiceService {
	
	private final AccountRepo accountRepo;
	private final AddressRepo addressRepo;
	private final ProductRepo productRepo;
	private final InvoiceRepo invoiceRepo;

	@Transactional
	public int invoice(AddressForm address, Map<Integer, Integer> items) {
		
		// Customer
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		var customer = accountRepo.findById(username).orElseThrow();
		
		// Address
		var shippingAddress = getShippingAddress(customer, address);
		
		// Create Invoice
		var invoice = new Invoice();
		invoice.setCustomer(customer);
		invoice.setShipping(shippingAddress);
		invoice.setSaleTime(LocalDateTime.now());
		
		var shops = new HashMap<Shop, InvoiceShop>();

		// Product
		for(var entry : items.entrySet()) {
			var product = productRepo.findById(entry.getKey()).orElseThrow();
			var item = new InvoiceItem();
			item.setProduct(product);
			item.setQuentity(entry.getValue());
			item.setSalePrice(product.getPrice());
			
			var invoiceForShop = shops.get(product.getShop());
			
			if(null == invoiceForShop) {
				invoiceForShop = new InvoiceShop();
				invoiceForShop.setStatus(Status.Ordered);
				invoice.addInvoiceForShop(invoiceForShop);
				shops.put(product.getShop(), invoiceForShop);
			}
			
			invoiceForShop.addItem(item);
		}
		
		return invoiceRepo.save(invoice).getId();
	}

	private Address getShippingAddress(Account customer, AddressForm form) {
		
		if(form.getId() > 0) {
			return addressRepo.findById(form.getId()).orElseThrow();
		}
		
		var entity = form.entity();
		entity.setAccount(customer);
		
		return addressRepo.save(entity);
	}
}
