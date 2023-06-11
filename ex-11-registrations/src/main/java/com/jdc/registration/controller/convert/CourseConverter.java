package com.jdc.registration.controller.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.jdc.registration.service.CourseService;
import com.jdc.registration.service.entity.Course;

@Component
public class CourseConverter implements Converter<String, Course>{
	
	@Autowired
	private CourseService service;

	@Override
	public Course convert(String str) {
		
		if(StringUtils.hasLength(str)) {
			var id = Integer.parseInt(str);
			return service.findById(id);
		}
		
		return null;
	}

}
