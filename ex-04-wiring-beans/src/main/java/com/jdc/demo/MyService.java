package com.jdc.demo;

import org.springframework.stereotype.Component;

@Component
public class MyService {
	
	private String hostIp;
	private String portNum;
	private int retriedCount;
	
	public MyService() {
		hostIp = "localhost";
		portNum = "80";
		retriedCount = 20;
	}
	
	public MyService(String hostIp, String portNum, int retriedCount) {
		super();
		this.hostIp = hostIp;
		this.portNum = portNum;
		this.retriedCount = retriedCount;
	}

	public void sendMessage(String message) {
		System.out.printf("""
				Host : %s
				Port : %s
				Try  : %s
				Message is %s
				""", hostIp, portNum, retriedCount, message);
	}
}
