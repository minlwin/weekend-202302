package com.jdc.demo.binding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/shoppers.properties")
public class Ex14ThymeleafBindingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex14ThymeleafBindingApplication.class, args);
	}

}
