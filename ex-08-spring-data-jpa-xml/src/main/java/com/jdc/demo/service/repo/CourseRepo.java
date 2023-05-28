package com.jdc.demo.service.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.service.entity.Course;

public interface CourseRepo extends JpaRepositoryImplementation<Course, Integer>{

}
