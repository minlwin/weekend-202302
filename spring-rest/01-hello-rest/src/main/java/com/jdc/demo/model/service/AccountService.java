package com.jdc.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.model.BusinessException;
import com.jdc.demo.model.dto.AccountForm;
import com.jdc.demo.model.entity.Account;
import com.jdc.demo.model.repo.AccountRepo;

@Service
@Transactional(readOnly = true)
public class AccountService {
	
	@Autowired
	private AccountRepo repo;

	public List<Account> findAll() {
		return repo.findAll();
	}

	@Transactional
	public Account save(AccountForm form) {
		return repo.save(form.entity());
	}

	public Account findById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new BusinessException("There is no account with id %s.".formatted(id)));
	}

}
