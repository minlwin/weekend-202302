package com.jdc.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.demo.service.entity.Course;
import com.jdc.demo.service.entity.Course.Level;
import com.jdc.demo.service.repo.CourseRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional(readOnly = true)
public class CourseService {
	
	@Autowired
	private CourseRepo repo;
	
	public List<Course> searchAll() {
		return repo.findAll();
	}
	
	public Course findById(Integer id) {
		return repo.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Transactional
	public int save(Course course) {
		return repo.save(course).getId();
	}

	public List<Course> search(Optional<Level> level, Optional<String> keyword) {
		return repo.findAll(withLevel(level).and(withKeyword(keyword)));
	}

	private Specification<Course> withLevel(Optional<Level> data) {
		return data.isEmpty() ? Specification.where(null) : 
			(root, query, cb) -> cb.equal(root.get("level"), data.get());
	}
	
	private Specification<Course> withKeyword(Optional<String> data) {
		return data.filter(StringUtils::hasLength).isEmpty() ? Specification.where(null) : 
			// lower(s.name) like ?
			(root, query, cb) -> cb.like(cb.lower(root.get("name")), 
					data.get().toLowerCase().concat("%"));
	}
}
