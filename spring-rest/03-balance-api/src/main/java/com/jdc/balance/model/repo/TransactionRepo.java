package com.jdc.balance.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.balance.model.entity.Transaction;

public interface TransactionRepo extends JpaRepositoryImplementation<Transaction, Long>{

	Long countByOwnerId(int id);

}
