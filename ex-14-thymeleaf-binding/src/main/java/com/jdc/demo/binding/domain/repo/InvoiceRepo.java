package com.jdc.demo.binding.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.binding.domain.entity.Invoice;

public interface InvoiceRepo extends JpaRepositoryImplementation<Invoice, Integer> {

	long countByCustomerEmail(String username);

}