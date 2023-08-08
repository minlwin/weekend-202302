package com.jdc.balance.utils.exceptions;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Aspect
@Component
public class BalanceValidationAspect {

	@Pointcut("within(com.jdc.balance.api.*)")
	public void apiClass() {}
	
	@Before(value = "apiClass() && args(..,result)", argNames = "result")
	public void check(BindingResult result) {
		if(result.hasErrors()) {
			throw new BalanceValidationException(result);
		}
	}
}
