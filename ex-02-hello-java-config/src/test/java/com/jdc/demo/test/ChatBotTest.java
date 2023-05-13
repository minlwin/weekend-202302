package com.jdc.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.config.AppConfig;
import com.jdc.demo.ChatBot;

public class ChatBotTest {
	
	private AnnotationConfigApplicationContext context;
	
	@BeforeEach
	void init() {
		context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
	}
	
	@Test
	void test() {
		var bot = context.getBean(ChatBot.class);
		assertNotNull(bot);
		
		var result = bot.talk("Hello");
		assertEquals("I've no idea. Please teach me.", result);
		
		result = bot.talk("Hi!");
		assertEquals("Thank you for your kindness.", result);
		
		result = bot.talk("Hello");
		assertEquals("Hi!", result);
	
	}
	
	@AfterEach
	void close() {
		context.close();
	}

}
