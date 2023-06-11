package com.jdc.registration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.registration.service.entity.Section;
import com.jdc.registration.service.repo.RegistrationRepo;

@Service
public class RegistrationService {
	
	private RegistrationRepo repo;

	public List<Section> findSectionForStudent(String loginId) {
		return repo.findSectionByStudentEmail(loginId);
	}

}
