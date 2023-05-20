package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.demo.MyClient;

public class JavaBasedConfigTest {

	@Test
	void test() {
		
		try(var context = new AnnotationConfigApplicationContext(JavaBasedConfig.class)) {
			var client = context.getBean(MyClient.class);
			client.sendRequest();
		}
		
	}
}
