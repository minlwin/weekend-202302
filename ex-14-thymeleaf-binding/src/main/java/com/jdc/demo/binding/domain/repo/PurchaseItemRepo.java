package com.jdc.demo.binding.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.binding.domain.entity.PurchaseItem;

public interface PurchaseItemRepo extends JpaRepositoryImplementation<PurchaseItem, Integer> {

}