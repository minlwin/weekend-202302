package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.AppConfig;
import com.jdc.demo.BeanA;

@SpringJUnitConfig(classes = AppConfig.class)
public class CircularDependencyTest {

	@Autowired
	private BeanA bean;
	
	@Test
	void test() {
		assertNotNull(bean);
	}
}
