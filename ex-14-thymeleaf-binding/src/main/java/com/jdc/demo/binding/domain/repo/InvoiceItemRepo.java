package com.jdc.demo.binding.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.binding.domain.entity.InvoiceItem;

public interface InvoiceItemRepo extends JpaRepositoryImplementation<InvoiceItem, Integer> {

}