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

	public Section findById(Integer integer) {
		// TODO Auto-generated method stub
		return null;
	}

	public Section save(Section section) {
		// TODO Auto-generated method stub
		return null;
	}

}
