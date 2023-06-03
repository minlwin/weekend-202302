package com.jdc.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.service.entity.Account;
import com.jdc.demo.service.entity.Account.Role;
import com.jdc.demo.service.repo.AccountRepo;

@Component
public class DefaultUserInitializer {
	
	@Autowired
	private AccountRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	@EventListener(classes = ContextRefreshedEvent.class)
	public void createUser() {
		if(repo.count() == 0L) {
			var data = new Account();
			data.setName("Kyaw Kyaw");
			data.setLoginId("kyaw@gmail.com");
			data.setPassword(passwordEncoder.encode("kyawkyaw"));
			data.setRole(Role.Office);
			data.setActivated(true);
			data.setExpired(false);
			
			repo.save(data);
		}
	}
}
