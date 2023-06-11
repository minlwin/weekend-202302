package com.jdc.registration.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.registration.service.entity.Registration;
import com.jdc.registration.service.entity.Section;
import com.jdc.registration.service.repo.RegistrationRepo;

@Service
@Transactional(readOnly = true)
public class RegistrationService {
	
	@Autowired
	private RegistrationRepo repo;

	@PreAuthorize("hasAuthority('Student')")
	public List<Section> findSectionForStudent(String loginId) {
		return repo.findSectionByStudentEmail(loginId);
	}

	@PreAuthorize("hasAuthority('Office')")
	public List<Registration> search(Optional<Integer> course, Optional<Integer> teacher, Optional<LocalDate> from) {
		return repo.findAll(withCourse(course).and(withTeacher(teacher)).and(withFromDate(from)));
	}
	
	private Specification<Registration> withCourse(Optional<Integer> data) {
		
		if(data.isEmpty()) {
			return Specification.where(null);
		}
		
		return (root, query, cb) -> cb.equal(root.get("section").get("course").get("id"), data.get());
	}

	private Specification<Registration> withTeacher(Optional<Integer> data) {
		if(data.isEmpty()) {
			return Specification.where(null);
		}
		
		return (root, query, cb) -> cb.equal(root.get("section").get("teacher").get("id"), data.get());
	}

	private Specification<Registration> withFromDate(Optional<LocalDate> data) {
		if(data.isEmpty()) {
			return Specification.where(null);
		}
		
		return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("section").get("startDate"), data.get());
	}	

}
