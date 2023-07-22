package com.jdc.demo.binding.security;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AppAuditorProvider implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		var authentication = SecurityContextHolder.getContext().getAuthentication();
		return Optional.ofNullable(authentication.getName());
	}

}
