package com.jdc.demo.service.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.service.entity.Account;

public interface AccountRepo extends JpaRepositoryImplementation<Account, Integer>{

	Optional<Account> findOneByLoginId(String loginId);
}
