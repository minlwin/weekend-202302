package com.jdc.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.demo.service.entity.Teacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional(readOnly = true)
public class TeacherService {
	
	@PersistenceContext
	private EntityManager em;

	public List<Teacher> search(Optional<String> name, Optional<String> phone) {
		
		var sb = new StringBuffer("select t from Teacher t where 1 = 1");
		var params = new HashMap<String, Object>();
		
		if(name.filter(a -> !StringUtils.hasLength(a)).isPresent()) {
			sb.append(" and lower(t.name) like lower(:name)");
			params.put("name", name.get().concat("%"));
		}
		
		if(phone.filter(a -> !StringUtils.hasLength(a)).isPresent()) {
			sb.append(" and t.phone like :phone");
			params.put("phone", phone.get().concat("%"));
		}
		
		var query = em.createQuery(sb.toString(), Teacher.class);
		for(var key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}

		return query.getResultList();
	}

	public Teacher findById(Integer id) {
		return em.find(Teacher.class, id);
	}

	@Transactional
	public Integer save(Teacher form) {
		return em.merge(form).getId();
	}

}
