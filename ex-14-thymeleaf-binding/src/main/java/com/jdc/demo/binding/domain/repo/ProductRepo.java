package com.jdc.demo.binding.domain.repo;

import java.io.Serializable;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.binding.domain.entity.Product;

public interface ProductRepo extends JpaRepositoryImplementation<Product, Integer>, Serializable {

	Stream<Product> findByShopId(int id);
}