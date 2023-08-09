package com.jdc.balance.utils.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import com.jdc.balance.model.entity.Auditor;
import com.jdc.balance.service.LoginUserService;

@Component
public class AppUserFinder implements AuditorAware<Auditor>{
	
	@Autowired
	private LoginUserService loginUserService;

	@Override
	public Optional<Auditor> getCurrentAuditor() {
		return Optional.ofNullable(Auditor.of(loginUserService.getLoginUser()));
	}

}
