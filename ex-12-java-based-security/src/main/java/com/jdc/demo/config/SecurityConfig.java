package com.jdc.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
@EnableWebSecurity
@ComponentScan("com.jdc.demo.security")
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// for programmatic authentication
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	// for programmatic authentication
	@Bean
	SecurityContextRepository securityContextRepository() {
		return new HttpSessionSecurityContextRepository();
	}

	// for JSP Security Tag Library
	@Bean
	SecurityExpressionHandler<FilterInvocation> securityExpressionHandler() {
		return new DefaultWebSecurityExpressionHandler();
	}
	
	@Bean
	SecurityFilterChain http(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(registry -> {
			registry
				.requestMatchers("/login", "/signup", "/resources/**", "/").permitAll()
				.requestMatchers("/office/**").hasAuthority("Office")
				.requestMatchers("/teacher/**").hasAnyAuthority("Office", "Teacher")
				.requestMatchers("/student/**").hasAuthority("Student")
				.anyRequest().denyAll();
			
		});
		
		http.formLogin(config -> {
			config.loginPage("/login").defaultSuccessUrl("/");
		});
		
		http.logout(config -> {
			config.logoutSuccessUrl("/");
		});
		
		http.exceptionHandling(config -> {
			config.accessDeniedPage("/403");
		});
		
		
		
		return http.build();
	}
}
