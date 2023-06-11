package com.jdc.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.registration.service.entity.Section;
import com.jdc.registration.service.repo.SectionRepo;

@Service
@Transactional(readOnly = true)
public class SectionService {
	
	@Autowired
	private SectionRepo repo;

	public List<Section> findForTeacher(String loginId) {
		return repo.findByTeacherEmail(loginId);
	}

	public Section findById(Integer id) {
		return repo.findById(id).orElseThrow();
	}

	@Transactional
	public Section save(Section section) {
		return repo.save(section);
	}

}
