package com.jdc.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MyService {
	
	public MyService() {
		System.out.println("Create My Service");
	}

	public void doJob() {
		System.out.println("Working My Service.");
	}
}
