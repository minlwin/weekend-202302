package com.jdc.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.entity.Company;
import com.jdc.demo.repo.CompanyRepo;


@Service
@Transactional(readOnly = true)
public class CompanyService {
	
	@Autowired
	private CompanyRepo repo;

	public List<Company> findAll() {
		return repo.findAll();
	}

	@Transactional
	public void save(Company form) {
		repo.save(form);
	}

}
