package com.jdc.balance.utils.security;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.jdc.balance.model.entity.Auditor;

@Component
public class AppUserFinder implements AuditorAware<Auditor>{

	@Override
	public Optional<Auditor> getCurrentAuditor() {
		
		SecurityContext security = SecurityContextHolder.getContext();
		Authentication auth = security.getAuthentication();
		
		if(null != auth && auth.isAuthenticated()) {
			
		}
		
		return Optional.empty();
	}

}
