package com.jdc.registration.service.security;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.registration.service.repo.AccountRepo;

@Service
public class AppUserDetailsService implements UserDetailsService{
	
	@Autowired
	private AccountRepo repo;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findOneByEmail(username).map(a -> User.withUsername(username)
					.password(a.getPassword())
					.authorities(a.getRole().name())
					.accountLocked(!a.isActivated())
					.accountExpired(isExpired(a.getRetiredAt()))
					.build())
				.orElseThrow(() -> new UsernameNotFoundException(username));
	}
	
	private boolean isExpired(LocalDate retiredAt) {
		if(null == retiredAt) {
			return false;
		}
		
		return retiredAt.isAfter(LocalDate.now());
	}

}
