package com.jdc.demo.binding.domain.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.binding.domain.entity.Category;

public interface CategoryRepo extends JpaRepositoryImplementation<Category, Integer> {

	Optional<Category> findOneByName(String name);
}