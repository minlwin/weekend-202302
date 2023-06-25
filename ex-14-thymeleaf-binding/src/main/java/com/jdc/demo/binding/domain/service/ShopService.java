package com.jdc.demo.binding.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.binding.domain.dto.form.ShopForm;
import com.jdc.demo.binding.domain.repo.ShopRepo;

@Service
@Transactional(readOnly = true)
public class ShopService {
	
	@Autowired
	private ShopRepo repo;

	public ShopForm findFormById(Integer id) {
		return repo.findById(id).map(ShopForm::from).orElseThrow();
	}

	@Transactional
	public int save(ShopForm form) {
		System.out.println(form);
		if(form.getId() == 0) {
			// Create
			var entity = form.entity();
			// Get Login Id from Security Context
			
			// Find User by login id
			
			// set user to entity
			
			// save entity
			
			// return id
		}
		
		// find entity with id
		
		// Set Name and greeting to entity
		return 0;
	}

}
