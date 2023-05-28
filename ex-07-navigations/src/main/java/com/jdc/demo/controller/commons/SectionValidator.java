package com.jdc.demo.controller.commons;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jdc.demo.service.entity.Section;

public class SectionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Section.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(null != target && target instanceof Section section) {
			LocalDateTime startTime = getDateTime(section.getStartTime());
			LocalDateTime endTime = getDateTime(section.getEndTime());
			
			if(null != startTime && null != endTime) {
				if(startTime.isAfter(endTime)) {
					errors.rejectValue("endTime", null, "End time must be later from start time.");
				}
			}
		}
	}

	private LocalDateTime getDateTime(String string) {
		return StringUtils.hasLength(string) ? LocalDateTime.of(LocalDate.now(), LocalTime.parse(string)) : null;
	}

}
