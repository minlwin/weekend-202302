package com.jdc.registration.service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.registration.service.entity.Section;

public interface SectionRepo extends JpaRepositoryImplementation<Section, Integer>{

	// select s from Section s where s.teacher.email = ?1
	List<Section> findByTeacherEmail(String email);
	
	List<Section> findByAcceptableIsTrue();
}
