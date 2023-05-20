package com.jdc.demo;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Type3Bean {

	@PostConstruct
	private void init() {
		System.out.println("Initializing Type 3 Bean");
	}

	public void shutdown() throws IOException {
		System.out.println("Closing Type 3 Bean");
	}
	
}
