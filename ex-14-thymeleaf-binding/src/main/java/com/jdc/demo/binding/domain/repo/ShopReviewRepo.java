package com.jdc.demo.binding.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.binding.domain.entity.ShopReview;

public interface ShopReviewRepo extends JpaRepositoryImplementation<ShopReview, Integer> {

}
