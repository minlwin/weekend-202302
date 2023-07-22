package com.jdc.registration.service.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.registration.service.entity.Teacher;

public interface TeacherRepo extends JpaRepositoryImplementation<Teacher, Integer>{
	
	Optional<Teacher> findOneByEmail(String email);
}
