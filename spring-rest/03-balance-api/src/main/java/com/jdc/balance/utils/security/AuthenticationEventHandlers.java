package com.jdc.balance.utils.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import com.jdc.balance.service.AccessLogService;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class AuthenticationEventHandlers {
	
	private Logger logger = LoggerFactory.getLogger(AuthenticationEventHandlers.class);
	
	@Autowired
	private AccessLogService service;

	@EventListener
	public void handle(AuthenticationSuccessEvent event) {
		logger.info(event.getClass().getSimpleName());
		service.success(event);
	}
	
	@EventListener
	public void handle(AbstractAuthenticationFailureEvent event) {
		logger.info(event.getException().getClass().getSimpleName());
		service.fails(event);
	}
}
