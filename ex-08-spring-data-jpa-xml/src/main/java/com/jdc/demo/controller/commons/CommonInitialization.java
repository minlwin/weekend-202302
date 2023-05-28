package com.jdc.demo.controller.commons;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class CommonInitialization {
	
	@InitBinder
	void init(WebDataBinder binder) {
		binder.addCustomFormatter(new LocalDateFormatter());
	}

}
