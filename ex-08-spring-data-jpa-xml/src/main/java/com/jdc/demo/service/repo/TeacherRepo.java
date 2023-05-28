package com.jdc.demo.service.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.service.entity.Teacher;

public interface TeacherRepo extends JpaRepositoryImplementation<Teacher, Integer>{

}
