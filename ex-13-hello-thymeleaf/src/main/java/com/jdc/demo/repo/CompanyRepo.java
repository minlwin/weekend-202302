package com.jdc.demo.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.entity.Company;

public interface CompanyRepo extends JpaRepositoryImplementation<Company, Integer>{

}
