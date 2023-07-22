package com.jdc.registration.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.registration.service.entity.Registration;
import com.jdc.registration.service.entity.Section;
import com.jdc.registration.service.entity.Student;
import com.jdc.registration.service.form.RegistrationForm;
import com.jdc.registration.service.repo.RegistrationRepo;
import com.jdc.registration.service.repo.SectionRepo;
import com.jdc.registration.service.repo.StudentRepo;

@Service
@Transactional(readOnly = true)
public class RegistrationService {
	
	@Autowired
	private RegistrationRepo registrationRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private SectionRepo sectionRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public void save(RegistrationForm form) {
		
		Student student = form.getStudent();
		student.setPassword(passwordEncoder.encode(form.getPassword()));
		
		student = studentRepo.save(student);
		
		var section = sectionRepo.findById(form.getSectionId()).orElseThrow();
		
		var registration = new Registration();
		registration.setSection(section);
		registration.setStudent(student);
		registration.setRegistAt(LocalDateTime.now());
		registration.setRemark("New Student Registration.");
		
		registrationRepo.save(registration);
	}	


	@PreAuthorize("hasAuthority('Student')")
	public List<Section> findSectionForStudent(String loginId) {
		return registrationRepo.findByStudentEmail(loginId)
				.stream().map(a -> a.getSection()).distinct().toList();
	}

	@PreAuthorize("hasAuthority('Office')")
	public List<Registration> search(Optional<Integer> course, Optional<Integer> teacher, Optional<LocalDate> from) {
		return registrationRepo.findAll(withCourse(course).and(withTeacher(teacher)).and(withFromDate(from)));
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
