package com.jdc.demo.binding.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.binding.domain.dto.form.SignUpForm;
import com.jdc.demo.binding.domain.repo.AccountRepo;

@Service
public class SignUpService {

	@Autowired
	private AccountRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public void signUp(SignUpForm form) {
		repo.save(form.entity(passwordEncoder::encode));
	}
	
}
