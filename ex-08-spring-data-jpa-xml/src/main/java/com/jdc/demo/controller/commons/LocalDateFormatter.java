package com.jdc.demo.controller.commons;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

public class LocalDateFormatter implements Formatter<LocalDate>{

	private static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Override
	public String print(LocalDate object, Locale locale) {
		
		if(null != object) {
			return object.format(df);
		}
		
		return null;
	}

	@Override
	public LocalDate parse(String text, Locale locale) throws ParseException {
		
		if(StringUtils.hasLength(text)) {
			return LocalDate.parse(text, df);
		}
		
		return null;
	}

}
