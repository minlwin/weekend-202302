package com.jdc.demo.binding.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.binding.domain.entity.Shop;

public interface ShopRepo extends JpaRepositoryImplementation<Shop, Integer> {

}