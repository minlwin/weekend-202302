package com.jdc.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationLoader extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {
			DatabaseConfig.class, SecurityConfig.class, WebMvcConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
