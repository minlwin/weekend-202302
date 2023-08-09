package com.jdc.balance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.balance.model.entity.Member;
import com.jdc.balance.model.form.SignUpForm;
import com.jdc.balance.model.repo.MemberRepo;
import com.jdc.balance.utils.exceptions.BalanceBusinessException;

@Service
public class LoginUserService {

	@Autowired
	private MemberRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional(readOnly = true)
	public Member getLoginUser() {
		
		var authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication.isAuthenticated()) {
			var username = SecurityContextHolder.getContext().getAuthentication().getName();
			return repo.findOneByEmail(username)
					.orElseThrow(() -> new BalanceBusinessException("You need to be a member for this operation."));
		}
		
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void signUp(SignUpForm form) {
		
		if(repo.countByEmail(form.email()) > 0) {
			throw new BalanceBusinessException("Your email already has been used by other member.");
		}
		
		repo.save(form.entity(passwordEncoder));
	}
}
