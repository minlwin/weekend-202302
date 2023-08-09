package com.jdc.balance.utils.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jdc.balance.model.entity.Member;
import com.jdc.balance.model.enums.MemberRole;
import com.jdc.balance.model.enums.MemberStatus;
import com.jdc.balance.model.repo.MemberRepo;

@Component
public class AdminUserInitializer {

	@Autowired
	private MemberRepo repo;
	@Autowired
	private PasswordEncoder encoder;
	
	@EventListener(value = ContextRefreshedEvent.class)
	public void initialize() {
		
		if(repo.count() == 0L) {
			var entity = new Member();
			entity.setEmail("minlwin@gmail.com");
			entity.setName("Zaw Min Lwin");
			entity.setRole(MemberRole.Admin);
			entity.setStatus(MemberStatus.Active);
			entity.setPhone("09782003098");
			entity.setPassword(encoder.encode("password"));
			
			repo.save(entity);
		}
	}
}
