package com.jdc.balance.utils.security;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jdc.balance.model.entity.Member;
import com.jdc.balance.model.enums.MemberStatus;
import com.jdc.balance.model.repo.MemberRepo;

@Service
public class AppUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var member = repo.findOneByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Please check your email."));
		return User.withUsername(username)
				.authorities(member.getRole().name())
				.password(member.getPassword())
				.disabled(!isActive(member))
				.build();
	}
	
	private boolean isActive(Member member) {
		if(null != member.getRegistrationDate() && member.getRegistrationDate().isBefore(LocalDate.now())) {
			return false;
		}
		
		return member.getStatus() == MemberStatus.Active;
	}

}
