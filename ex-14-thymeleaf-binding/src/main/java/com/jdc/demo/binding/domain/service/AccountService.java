package com.jdc.demo.binding.domain.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.binding.domain.dto.vo.IdWithName;
import com.jdc.demo.binding.domain.repo.AccountRepo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepo accountRepo;
	
	public List<IdWithName<String>> findTopCustomers() {
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		return accountRepo.findDistinctFirst10ByInvoiceInvoicesForShopsShopOwnerEmail(username)
				.map(IdWithName::from).toList();
	}
}
