package com.jdc.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyClient {

	private MyService service;

	public MyClient(MyService service) {
		super();
		this.service = service;
		System.out.println("Create My Client");
	}
	
	public void sendRequest() {
		service.doJob();
	}
}
