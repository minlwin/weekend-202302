package com.jdc.demo.binding;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jdc.demo.binding.domain.service.formatter.DateTimes;
import com.jdc.demo.binding.domain.service.formatter.NumberFormat;

@Configuration(proxyBeanMethods = false)
public class WebConfig implements WebMvcConfigurer{
	
	@Value("${app.photo.path}")
	private String photoUrlPath;
	
	@Value("${app.photo.folder}")
	private String photoFilePath;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/public/home");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(photoUrlPath).addResourceLocations("file://%s".formatted(photoFilePath));
	}
	
	@Bean
	NumberFormat numbers() {
		return new NumberFormat();
	}
	
	@Bean
	DateTimes dates() {
		return new DateTimes();
	}
}
