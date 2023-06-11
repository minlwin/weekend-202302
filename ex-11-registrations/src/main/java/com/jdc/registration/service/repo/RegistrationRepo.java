package com.jdc.registration.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.registration.service.entity.Registration;
import com.jdc.registration.service.entity.Section;

public interface RegistrationRepo extends JpaRepositoryImplementation<Registration, Integer>{

	// select r.section from Registration r where r.student.email = ?1
	List<Section> findSectionByStudentEmail(String email);
}
