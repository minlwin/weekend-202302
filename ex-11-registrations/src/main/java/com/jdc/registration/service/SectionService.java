package com.jdc.registration.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.registration.service.entity.Section;
import com.jdc.registration.service.repo.SectionRepo;

@Service
@Transactional(readOnly = true)
public class SectionService {
	
	@Autowired
	private SectionRepo repo;

	public List<Section> getAvailables() {
		return repo.findByAcceptableIsTrue();
	}
	
	public Section findById(Integer id) {
		return repo.findById(id).orElseThrow();
	}

	@PreAuthorize("hasAuthority('Teacher')")
	public List<Section> findForTeacher(String loginId) {
		return repo.findByTeacherEmail(loginId);
	}

	@Transactional
	@PreAuthorize("hasAuthority('Teacher')")
	public Section save(Section section) {
		return repo.save(section);
	}

	@PreAuthorize("hasAuthority('Office')")
	public List<Section> search(Optional<Integer> course, Optional<Integer> teacher, Optional<LocalDate> from) {
		return repo.findAll(withCourse(course).and(withTeacher(teacher)).and(withFromDate(from)));
	}
	
	private Specification<Section> withCourse(Optional<Integer> data) {
		
		if(data.isEmpty()) {
			return Specification.where(null);
		}
		
		return (root, query, cb) -> cb.equal(root.get("course").get("id"), data.get());
	}

	private Specification<Section> withTeacher(Optional<Integer> data) {
		if(data.isEmpty()) {
			return Specification.where(null);
		}
		
		return (root, query, cb) -> cb.equal(root.get("teacher").get("id"), data.get());
	}

	private Specification<Section> withFromDate(Optional<LocalDate> data) {
		if(data.isEmpty()) {
			return Specification.where(null);
		}
		
		return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("startDate"), data.get());
	}


}
