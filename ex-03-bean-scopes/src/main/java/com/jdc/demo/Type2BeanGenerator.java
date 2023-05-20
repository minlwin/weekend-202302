package com.jdc.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Type2BeanGenerator {

	@Bean(initMethod = "initBean", destroyMethod = "cleanUp")
	Type2Bean type2Bean() {
		return new Type2Bean();
	}
}
