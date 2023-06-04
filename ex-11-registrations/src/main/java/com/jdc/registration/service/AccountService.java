package com.jdc.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jdc.registration.service.dto.AccountDto;
import com.jdc.registration.service.entity.Account;
import com.jdc.registration.service.entity.Account.Role;
import com.jdc.registration.service.entity.Office;
import com.jdc.registration.service.entity.Student;
import com.jdc.registration.service.entity.Teacher;
import com.jdc.registration.service.form.AccountForm;
import com.jdc.registration.service.repo.AccountRepo;
import com.jdc.registration.service.repo.OfficeRepo;
import com.jdc.registration.service.repo.StudentRepo;
import com.jdc.registration.service.repo.TeacherRepo;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepo accountRepo;
	@Autowired
	private TeacherRepo teacherRepo;
	@Autowired
	private OfficeRepo officeRepo;
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<AccountDto> search(Optional<Role> role, Optional<String> name) {
		return accountRepo.findAll(whichRole(role).and(whichName(name)))
				.stream().map(AccountDto::new).toList();
	}
	
	Specification<Account> whichRole(Optional<Role> data) {
		if(data.isEmpty()) {
			return Specification.where(null);
		}
		
		return (root, query, cb) -> cb.equal(root.get("role"), data.get());
	}

	Specification<Account> whichName(Optional<String> data) {
		if(data.isEmpty()) {
			return Specification.where(null);
		}
		
		// lower(a.name) like 'thi%'
		return (root, query, cb) -> cb.like(cb.lower(root.get("name")), data.get().toLowerCase().concat("%"));
	}

	public AccountForm getFormById(Integer id) {
		return accountRepo.findById(id)
				.map(AccountForm::new).orElseThrow();
	}

	public void save(AccountForm form) {
		switch (form.getRole()) {
		case Office -> saveOffice(form);
		case Student -> saveStudent(form);
		case Teacher -> saveTeacher(form);
		default -> throw new IllegalArgumentException();
		}
	}
	
	private void saveTeacher(AccountForm form) {
		var entity = new Teacher();

		if(form.getId() > 0) {
			entity = teacherRepo.findById(form.getId()).orElseThrow();
		} else {
			entity.setPassword(passwordEncoder.encode(form.getEmail()));
		}
		
		entity.setEmail(form.getEmail());
		entity.setName(form.getName());
		
		teacherRepo.save(entity);
	}

	private void saveOffice(AccountForm form) {
		var entity = new Office();

		if(form.getId() > 0) {
			entity = officeRepo.findById(form.getId()).orElseThrow();
		} else {
			entity.setPassword(passwordEncoder.encode(form.getEmail()));
		}
		
		entity.setEmail(form.getEmail());
		entity.setName(form.getName());
		
		officeRepo.save(entity);
	}

	private void saveStudent(AccountForm form) {
		var entity = new Student();

		if(form.getId() > 0) {
			entity = studentRepo.findById(form.getId()).orElseThrow();
		} else {
			entity.setPassword(passwordEncoder.encode(form.getEmail()));
		}
		
		entity.setEmail(form.getEmail());
		entity.setName(form.getName());
		
		studentRepo.save(entity);
	}
}
