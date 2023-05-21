package com.jdc.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdc.demo.service.entity.Course;
import com.jdc.demo.service.entity.Course.Level;

@Service
public class CourseService {

	public List<Course> search(Optional<Level> level, Optional<String> keyword) {
		return List.of();
	}

	public Course findById(Integer integer) {
		return null;
	}

	public int save(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

}
