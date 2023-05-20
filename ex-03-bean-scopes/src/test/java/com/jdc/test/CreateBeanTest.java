package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.demo.MyClient;
import com.jdc.demo.Type3Bean;

public class CreateBeanTest {

	@Test
	void test() {
		
		try(var context = new AnnotationConfigApplicationContext()) {
			context.scan("com.jdc.demo");
			context.refresh();
			
			var client = context.getBean(MyClient.class);
			client.sendRequest();
			
			context.getBean(MyClient.class);
			
			context.getBean(MyClient.class);
			
			context.getBean(Type3Bean.class);
		}
		
	}

}
