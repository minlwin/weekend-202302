package com.jdc.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jdc.demo.service.repo.AccountRepo;

@Service
public class AccountDetailsService implements UserDetailsService{
	
	@Autowired
	private AccountRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return repo.findOneByLoginId(username)
				.map(a -> User.builder()
						.username(username)
						.password(a.getPassword())
						.accountExpired(a.isExpired())
						.accountLocked(!a.isActivated())
						.authorities(a.getRole().name())
						.build()).orElseThrow();
	}

}
