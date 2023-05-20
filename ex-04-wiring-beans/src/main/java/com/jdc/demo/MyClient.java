package com.jdc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyClient {
	
	@Autowired
	@Qualifier("defaultService")
	private MyService service;
	
	public void sendHello() {
		service.sendMessage("Hello");
	}
}
