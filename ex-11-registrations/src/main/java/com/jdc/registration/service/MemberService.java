package com.jdc.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jdc.registration.service.entity.Account.Role;
import com.jdc.registration.service.repo.TeacherRepo;
import com.jdc.registration.service.entity.Section;
import com.jdc.registration.service.entity.Teacher;

@Service
public class MemberService {
	
	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private TeacherRepo teacherRepo;
	
	public List<Section> findOwnSections() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		// email
		String loginId = auth.getName();
		
		// Role List
		List<String> authorities = auth.getAuthorities().stream().map(a -> a.getAuthority()).toList();
		
		if(authorities.contains(Role.Student.name())) {
			return registrationService.findSectionForStudent(loginId);
		}
		
		if(authorities.contains(Role.Teacher.name())) {
			return sectionService.findForTeacher(loginId);
		}
		
		
		return null;
	}

	public Teacher getLoginTeacher() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// email
		String loginId = auth.getName();
		
		return teacherRepo.findOneByEmail(loginId).orElseThrow();
	}

}
