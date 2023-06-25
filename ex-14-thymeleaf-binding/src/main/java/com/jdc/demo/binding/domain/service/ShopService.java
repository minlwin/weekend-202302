package com.jdc.demo.binding.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.demo.binding.domain.dto.form.ShopForm;
import com.jdc.demo.binding.domain.repo.ShopRepo;

@Service
public class ShopService {
	
	@Autowired
	private ShopRepo repo;

	public ShopForm findFormById(Integer id) {
		return repo.findById(id).map(ShopForm::from).orElseThrow();
	}

}
