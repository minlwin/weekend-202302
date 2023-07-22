package com.jdc.demo.binding.domain.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.binding.domain.dto.form.AddressForm;
import com.jdc.demo.binding.domain.repo.AddressRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AddressService {
	
	private final AddressRepo repo;

	public List<AddressForm> findCustomerAddresses() {
		
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return repo.findByAccountEmail(username)
				.map(AddressForm::from).toList();
	}

	public AddressForm findFormById(int id) {
		return repo.findById(id).map(AddressForm::from).orElseThrow();
	}

	
}
