package com.jdc.demo.binding.domain.service;

import java.text.DecimalFormat;

public class NumberFormat {

	private static final DecimalFormat DF = new DecimalFormat("#,##0");
	
	public String format(int number) {
		return DF.format(number);
	}
}
