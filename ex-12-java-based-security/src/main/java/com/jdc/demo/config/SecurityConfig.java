package com.jdc.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityExpressionHandler<FilterInvocation> securityExpressionHandler() {
		return new DefaultWebSecurityExpressionHandler();
	}
	
	@Bean
	SecurityFilterChain http(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(registry -> {
			registry
				.requestMatchers("/login", "/resources/**", "/").permitAll()
				.requestMatchers("/office/**").hasAuthority("Office")
				.requestMatchers("/teacher/**").hasAnyAuthority("Office", "Teacher")
				.requestMatchers("/student/**").hasAuthority("Student")
				.anyRequest().denyAll();
			
		});
		
		http.formLogin(Customizer.withDefaults());
		http.logout(Customizer.withDefaults());
		
		return http.build();
	}
}
