package com.jdc.registration.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.registration.service.entity.Office;
import com.jdc.registration.service.entity.Account.Role;
import com.jdc.registration.service.repo.AccountRepo;

@Configuration
public class OfficeUserInitializer {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AccountRepo repo;

	@Transactional
	@EventListener(classes = ContextRefreshedEvent.class)
	void handle() {
		if(repo.count() == 0) {
			var entity = new Office();
			entity.setActivated(true);
			entity.setName("Office");
			entity.setEmail("office@gmail.com");
			entity.setPassword(passwordEncoder.encode("office"));
			entity.setRole(Role.Office);
			
			repo.save(entity);
		}
	}
}
