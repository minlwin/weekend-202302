package com.jdc.demo.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.entity.Project;

public interface ProjectRepo extends JpaRepositoryImplementation<Project, Integer>{

}
