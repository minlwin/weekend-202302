package com.jdc.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jdc.demo")
public class AppConfig {

	@Bean
	Map<String, String> memory() {
		return new HashMap<>();
	}
}
