package com.jdc.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.registration.service.entity.Course;
import com.jdc.registration.service.repo.CourseRepo;

@Service
@Transactional(readOnly = true)
public class CourseService {
	
	@Autowired
	private CourseRepo repo;

	public List<Course> findAll() {
		return repo.findAll();
	}

	public Course findById(int id) {
		return repo.findById(id).orElseThrow();
	}

	@Transactional
	public void save(Course dto) {
		repo.save(dto);
	}

}
