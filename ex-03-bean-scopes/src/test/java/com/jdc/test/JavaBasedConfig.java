package com.jdc.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.demo.MyClient;
import com.jdc.demo.MyService;

@Configuration
public class JavaBasedConfig {
	
	@Bean
	MyService service() {
		return new MyService();
	}

	@Bean
	MyClient client(MyService service) {
		return new MyClient(service);
	}
}
