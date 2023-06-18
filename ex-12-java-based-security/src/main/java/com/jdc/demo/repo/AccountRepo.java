package com.jdc.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.entity.Account;

public interface AccountRepo extends JpaRepositoryImplementation<Account, Integer>{

	Optional<Account> findOneByEmail(String username);
}
