package com.jdc.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.controller.form.SignUpForm;
import com.jdc.demo.repo.AccountRepo;

@Service
public class SignUpService {

	@Autowired
	private AccountRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public void signUp(SignUpForm form) {
		
		var entity = form.entity();
		entity.setPassword(passwordEncoder.encode(form.getPassword()));		
		repo.save(entity);
	}
}
