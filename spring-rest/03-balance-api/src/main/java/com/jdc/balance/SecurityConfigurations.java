package com.jdc.balance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.jdc.balance.model.enums.MemberRole;
import com.jdc.balance.utils.security.AppUserDetailsService;
import com.jdc.balance.utils.security.CustomAccessDeniedHandler;
import com.jdc.balance.utils.security.JwtTokenAuthenticationFilter;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:/jwt-tokens.properties")
public class SecurityConfigurations {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	@Bean
	AuthenticationProvider authenticationProvider(AppUserDetailsService appUserDetailsService, PasswordEncoder passwordEncoder) {
		var provider = new DaoAuthenticationProvider(passwordEncoder);
		provider.setUserDetailsService(appUserDetailsService);
		provider.setHideUserNotFoundExceptions(false);
		return provider;
	}
	
	@Bean
	SecurityFilterChain http(
			HttpSecurity security, 
			HandlerMappingIntrospector introspector,
			JwtTokenAuthenticationFilter jwtTokenAuthenticationFilter,
			CustomAccessDeniedHandler customAccessDeniedHandler) throws Exception {
		
		security.csrf(csrf -> csrf.disable());
		security.cors(cors -> {});
		
		security.authorizeHttpRequests(request -> {
			request.requestMatchers(new MvcRequestMatcher(introspector, "/public/**")).permitAll();
			request.requestMatchers(new MvcRequestMatcher(introspector, "/member/**")).hasAuthority(MemberRole.Admin.name());
			request.anyRequest().authenticated();
		});
		
		security.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		security.addFilterBefore(jwtTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		security.exceptionHandling(config -> {
			config.accessDeniedHandler(customAccessDeniedHandler);
			config.authenticationEntryPoint(customAccessDeniedHandler);
		});
		
		return security.build();
	}
}
