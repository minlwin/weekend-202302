package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.MyClient;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class WiringTest {
	
	@Autowired
	private MyClient client;
	
	@Test
	void doTest() {
		client.sendHello();
	}

}
