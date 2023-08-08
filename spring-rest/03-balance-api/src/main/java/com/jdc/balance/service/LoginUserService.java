package com.jdc.balance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.balance.model.entity.Member;
import com.jdc.balance.model.repo.MemberRepo;
import com.jdc.balance.utils.exceptions.BalanceBusinessException;

@Service
public class LoginUserService {

	@Autowired
	private MemberRepo repo;
	
	@Transactional(readOnly = true)
	public Member getLoginUser() {
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		return repo.findOneByEmail(username)
				.orElseThrow(() -> new BalanceBusinessException("You need to be a member for this operation."));
	}
}
