package com.jdc.demo.controller.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.jdc.demo.service.CourseService;
import com.jdc.demo.service.entity.Course;

@Convert
public class CourseConverter implements Converter<String, Course>{

	@Autowired
	private CourseService service;
	
	@Override
	public Course convert(String source) {
		if(StringUtils.hasLength(source)) {
			return service.findById(Integer.parseInt(source));
		}
		return null;
	}

}
