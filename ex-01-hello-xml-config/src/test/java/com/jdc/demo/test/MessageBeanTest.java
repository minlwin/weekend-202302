package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.demo.Message;

public class MessageBeanTest {

	GenericXmlApplicationContext context;
	
	@BeforeEach
	void init() {
		context = new GenericXmlApplicationContext("classpath:/application-config.xml");
	}
	
	@Test
	void test() {
		Message message = context.getBean(Message.class);
		assertNotNull(message);
		assertEquals("Hello from Bean Post Processor", message.getValue());
		
		context.publishEvent(message);
		
		context.publishEvent(new Message("This is not a bean."));
	}
	
	@AfterEach
	void close() {
		context.close();
	}
}
