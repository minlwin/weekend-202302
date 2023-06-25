package com.jdc.demo.binding;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration(proxyBeanMethods = false)
@EnableJpaAuditing(auditorAwareRef = "appAuditorProvider")
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityContextRepository securityContextRepository() {
		return new HttpSessionSecurityContextRepository();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain http(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(config -> {
			
			config.requestMatchers(
					"/", "/public/**", "/images/**", "/js/**", "/login").permitAll();
			
			config.requestMatchers("/admin/**").hasAuthority("Admin");
			config.requestMatchers("/member/**").hasAnyAuthority("Admin", "Member");
			
			config.anyRequest().denyAll();
		});
		
		http.formLogin(config -> {
			config.loginPage("/public/signin");
		});
		
		http.logout(withDefaults());
		
		return http.build();
	}
}
