package com.jdc.demo.binding;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/public/home");
		registry.addViewController("/public/signin").setViewName("/public/sign-in");
		registry.addViewController("/public/signup").setViewName("/public/sign-up");
	}
}
