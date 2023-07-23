package com.jdc.demo.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.model.entity.Account;

public interface AccountRepo extends JpaRepositoryImplementation<Account, Integer>{

}
