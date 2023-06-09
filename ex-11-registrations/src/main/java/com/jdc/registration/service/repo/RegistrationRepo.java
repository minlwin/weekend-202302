package com.jdc.registration.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.registration.service.entity.Registration;

public interface RegistrationRepo extends JpaRepositoryImplementation<Registration, Integer>{

	// select r from Registration r where r.student.email = ?1
	List<Registration> findByStudentEmail(String email);
}
