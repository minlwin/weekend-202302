package com.jdc.demo.binding.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jdc.demo.binding.domain.repo.AccountRepo;

@Service
public class AppUserDetailsService implements UserDetailsService{
	
	@Autowired
	private AccountRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findOneByEmail(username)
				.map(entity -> User.withUsername(username)
						.authorities(entity.getRole().name())
						.password(entity.getPassword())
						.disabled(entity.getAudit().isDeleted())
						.build())
				.orElseThrow(() -> new UsernameNotFoundException(username));
	}

}
