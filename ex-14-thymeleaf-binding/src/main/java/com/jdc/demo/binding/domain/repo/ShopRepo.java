package com.jdc.demo.binding.domain.repo;

import java.io.Serializable;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.binding.domain.entity.Shop;

public interface ShopRepo extends JpaRepositoryImplementation<Shop, Integer>, Serializable {
	
	Stream<Shop> findByOwnerEmail(String email);
	
}