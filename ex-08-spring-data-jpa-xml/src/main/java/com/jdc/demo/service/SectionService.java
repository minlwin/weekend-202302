package com.jdc.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.service.entity.Section;
import com.jdc.demo.service.repo.SectionRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional(readOnly = true)
public class SectionService {
	
	@Autowired
	private SectionRepo repo;
	
	public Section findById(Integer id) {
		return repo.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Transactional
	public Integer save(Section form) {
		return repo.save(form).getId();
	}

	public List<Section> search(Optional<LocalDate> dateFrom, Optional<String> teacher, Optional<String> course) {
		return repo.findAll(withDateFrom(dateFrom)
				.and(withTeacher(teacher))
				.and(withCourse(course)));
	}
	
	private Specification<Section> withDateFrom(Optional<LocalDate> data) {
		return data.isEmpty() ? Specification.where(null) : 
			(root, query, cb) -> cb.greaterThanOrEqualTo(root.get("startDate"), data.get());
	}

	private Specification<Section> withTeacher(Optional<String> data) {
		return data.isEmpty() ? Specification.where(null) : 
			(root, query, cb) -> cb.like(cb.lower(root.get("teacher").get("name")), 
					data.get().toLowerCase().concat("%"));
	}

	private Specification<Section> withCourse(Optional<String> data) {
		return data.isEmpty() ? Specification.where(null) : 
			(root, query, cb) -> cb.like(cb.lower(root.get("course").get("name")), 
					data.get().toLowerCase().concat("%"));
	}
}
