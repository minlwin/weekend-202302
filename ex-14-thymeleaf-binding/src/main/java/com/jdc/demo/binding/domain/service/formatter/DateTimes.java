package com.jdc.demo.binding.domain.service.formatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimes {

	private static DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("MMM dd, yyyy");
	
	public String formatDateTime(LocalDateTime data) {
		if(null != data) {
			return data.format(DATE_TIME_FORMAT);
		}
		return "";
	}
}
