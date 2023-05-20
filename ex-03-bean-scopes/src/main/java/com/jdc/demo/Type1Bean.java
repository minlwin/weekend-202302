package com.jdc.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Type1Bean implements InitializingBean, DisposableBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Type 1 Bean");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy Type 1 Bean");
	}

}
