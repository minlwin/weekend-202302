package com.jdc.demo.controller.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.jdc.demo.service.TeacherService;
import com.jdc.demo.service.entity.Teacher;

@Convert
public class TeacherConverter implements Converter<String, Teacher>{

	@Autowired
	private TeacherService service;
	
	@Override
	public Teacher convert(String source) {
		if(StringUtils.hasLength(source)) {
			return service.findById(Integer.parseInt(source));
		}
		return null;
	}

}
