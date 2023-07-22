package com.jdc.demo.binding.domain.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.binding.domain.entity.Account;
import com.jdc.demo.binding.domain.repo.AccountRepo;
import com.jdc.demo.binding.domain.repo.InvoiceRepo;
import com.jdc.demo.binding.domain.repo.ShopRepo;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@Scope("session")
@RequiredArgsConstructor
public class LoginUserHolder {

	private Account user;
	
	private final AccountRepo repo;
	private final ShopRepo shopRepo;
	private final InvoiceRepo invoiceRepo;
	
	private boolean hasShops;
	private boolean hasOrders;
	
	
	@PostConstruct
	@Transactional(readOnly = true)
	private void loadUser() {
		
		var authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(null != authentication 
				&& authentication instanceof UsernamePasswordAuthenticationToken 
				&& authentication.isAuthenticated()) {
			var username = authentication.getName();
			repo.findById(username).ifPresent(account -> this.user = account);
			
			hasShops = shopRepo.countByOwnerEmail(username) > 0;
			
			hasOrders = invoiceRepo.countByCustomerEmail(username) > 0;
		}
		
	}
	
	@EventListener
	public void onLoginSuccess(AuthenticationSuccessEvent event) {
		var username = event.getAuthentication().getName();
		repo.findById(username).ifPresent(account -> this.user = account);
		hasShops = shopRepo.countByOwnerEmail(username) > 0;
		hasOrders = invoiceRepo.countByCustomerEmail(username) > 0;
	}
	
	public Account getUser() {
		return user;
	}
	
	public boolean isHasShops() {
		return hasShops;
	}
	
	public boolean isHasOrders() {
		return hasOrders;
	}
}
