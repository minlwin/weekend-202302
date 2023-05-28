package com.jdc.demo.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.entity.Category;

public interface CategoryRepo extends JpaRepositoryImplementation<Category, Integer>{

	Category findOneByName(String name);
}
