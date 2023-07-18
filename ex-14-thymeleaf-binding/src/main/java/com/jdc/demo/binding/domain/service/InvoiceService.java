package com.jdc.demo.binding.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.binding.domain.dto.form.AddressForm;
import com.jdc.demo.binding.domain.dto.vo.InvoiceListVO;
import com.jdc.demo.binding.domain.dto.vo.InvoiceShopListVO;
import com.jdc.demo.binding.domain.dto.vo.InvoiceShopVO;
import com.jdc.demo.binding.domain.dto.vo.InvoiceVO;
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
import com.jdc.demo.binding.domain.repo.InvoiceShopRepo;
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
	private final InvoiceShopRepo invoiceShopRepo;

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
				invoiceForShop.setShop(product.getShop());
				invoiceForShop.setStatus(Status.Ordered);
				invoice.addInvoiceForShop(invoiceForShop);
				shops.put(product.getShop(), invoiceForShop);
			}
			
			invoiceForShop.addItem(item);
		}
		
		return invoiceRepo.save(invoice).getId();
	}

	public List<InvoiceShopListVO> searchSales(Optional<Integer> shop, Optional<Status> status, Optional<LocalDate> from, Optional<LocalDate> to) {
		return invoiceShopRepo.findAll(ShopCriteria.owner(SecurityContextHolder.getContext().getAuthentication().getName()).and(ShopCriteria.shop(shop).and(ShopCriteria.status(status).and(ShopCriteria.from(from).and(ShopCriteria.to(to))))))
				.stream().map(InvoiceShopListVO::from).toList();
	}

	public List<InvoiceListVO> searchOrders(Optional<LocalDate> from, Optional<LocalDate> to) {
		return invoiceRepo.findAll(InvoiceCriteria.from(from).and(InvoiceCriteria.to(to)))
				.stream().map(InvoiceListVO::from).toList();
	}
	
	public InvoiceShopVO findDetailsForShop(int id) {
		return invoiceShopRepo.findById(id).map(InvoiceShopVO::from).orElseThrow();
	}

	public InvoiceVO findDetailsForCustomer(int id) {
		return invoiceRepo.findById(id).map(InvoiceVO::from).orElseThrow();
	}	
	
	private Address getShippingAddress(Account customer, AddressForm form) {
		
		if(form.getId() > 0) {
			return addressRepo.findById(form.getId()).orElseThrow();
		}
		
		var entity = form.entity();
		entity.setAccount(customer);
		
		return addressRepo.save(entity);
	}

	private static class InvoiceCriteria {
		static Specification<Invoice> from(Optional<LocalDate> data) {
			if(data.isEmpty()) {
				return Specification.where(null);
			}
			
			return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("saleTime"), data.get().atStartOfDay());
		}

		static Specification<Invoice> to(Optional<LocalDate> data) {
			if(data.isEmpty()) {
				return Specification.where(null);
			}
			
			return (root, query, cb) -> cb.lessThan(root.get("saleTime"), data.get().plusDays(1).atStartOfDay());
		}
	}

	private static class ShopCriteria {
		
		static Specification<InvoiceShop> owner(String data) {
			return (root, query, cb) -> cb.equal(root.get("shop").get("owner").get("email"), data);
		}
		
		static Specification<InvoiceShop> shop(Optional<Integer> data) {
			if(data.isEmpty()) {
				return Specification.where(null);
			}
			
			return (root, query, cb) -> cb.equal(root.get("shop").get("id"), data.get());
		}
		
		static Specification<InvoiceShop> status(Optional<Status> data) {
			if(data.isEmpty()) {
				return Specification.where(null);
			}
			
			return (root, query, cb) -> cb.equal(root.get("status"), data.get());
		}

		static Specification<InvoiceShop> from(Optional<LocalDate> data) {
			if(data.isEmpty()) {
				return Specification.where(null);
			}
			
			return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("invoice").get("saleTime"), data.get().atStartOfDay());
		}

		static Specification<InvoiceShop> to(Optional<LocalDate> data) {
			if(data.isEmpty()) {
				return Specification.where(null);
			}
			
			return (root, query, cb) -> cb.lessThan(root.get("invoice").get("saleTime"), data.get().plusDays(1).atStartOfDay());
		}
	}

}
