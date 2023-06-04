package com.jdc.registration.service.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.registration.service.entity.Student;

public interface StudentRepo extends JpaRepositoryImplementation<Student, Integer>{

}
