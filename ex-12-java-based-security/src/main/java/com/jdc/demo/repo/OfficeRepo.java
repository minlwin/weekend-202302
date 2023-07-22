package com.jdc.demo.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.entity.Office;

public interface OfficeRepo extends JpaRepositoryImplementation<Office, Integer>{

}
