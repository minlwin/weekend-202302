package com.jdc.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.service.entity.Course;
import com.jdc.demo.service.entity.Course.Level;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional(readOnly = true)
public class CourseService {
	
	@PersistenceContext
	private EntityManager em;

	public List<Course> search(Optional<Level> level, Optional<String> keyword) {
		
		var sb = new StringBuffer("select c from Course c where 1 = 1");
		var params = new HashMap<String, Object>();
		
		if(level.isPresent()) {
			sb.append(" and c.level = :level");
			params.put("level", level.get());
		}
		
		if(keyword.filter(a -> !a.isBlank()).isPresent()) {
			sb.append(" and lower(c.name) like lower(:keyword)");
			params.put("keyword", keyword.get().concat("%"));
		}
		
		var query = em.createQuery(sb.toString(), Course.class);
		
		for(var key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		
		return query.getResultList();
	}

	public Course findById(Integer id) {
		return em.find(Course.class, id);
	}

	@Transactional
	public int save(Course course) {
		course = em.merge(course);
		return course.getId();
	}

}
