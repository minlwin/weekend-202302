package com.jdc.demo.binding.domain.repo;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.binding.domain.entity.Account;

public interface AccountRepo extends JpaRepositoryImplementation<Account, String> {

	Optional<Account> findOneByEmail(String email);
	
	Stream<Account> findDistinctFirst10ByInvoiceInvoicesForShopsShopOwnerEmail(String email);
}