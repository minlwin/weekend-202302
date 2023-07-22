package com.jdc.registration.service.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.registration.service.entity.Course;

public interface CourseRepo extends JpaRepositoryImplementation<Course, Integer>{

}
