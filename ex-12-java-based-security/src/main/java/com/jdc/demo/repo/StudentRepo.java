package com.jdc.demo.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.entity.Student;

public interface StudentRepo extends JpaRepositoryImplementation<Student, Integer>{

}
