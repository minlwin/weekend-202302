package com.jdc.demo.binding.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.binding.domain.dto.form.ShopForm;
import com.jdc.demo.binding.domain.dto.vo.ShopSummaryVO;
import com.jdc.demo.binding.domain.repo.AccountRepo;
import com.jdc.demo.binding.domain.repo.ShopRepo;

@Service
@Transactional(readOnly = true)
public class ShopService {
	
	@Autowired
	private ShopRepo repo;
	
	@Autowired
	private AccountRepo accountRepo;

	public ShopForm findFormById(Integer id) {
		return repo.findById(id).map(ShopForm::from).orElseThrow();
	}

	@Transactional
	public int save(ShopForm form) {

		if(form.getId() == 0) {
			// Create
			var entity = form.entity();

			// Get Login Id from Security Context
			var username = SecurityContextHolder.getContext().getAuthentication().getName();
			
			// Find User by login id
			var loginUser = accountRepo.findById(username).orElseThrow();
			
			// set user to entity
			entity.setOwner(loginUser);
			
			// save entity
			entity = repo.save(entity);
			
			// return id
			return entity.getId();
		}
		
		// find entity with id
		repo.findById(form.getId()).ifPresent(shop -> {
			// Set Name and greeting to entity
			shop.setName(form.getName());
			shop.setGreeting(form.getGreeting());
		});
		
		return form.getId();
	}

	public List<ShopSummaryVO> findOnerShops() {
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		return repo.findByOwnerEmail(username)
				.map(ShopSummaryVO::from).toList();
	}

}
