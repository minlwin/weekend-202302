package com.jdc.registration.service.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.registration.service.entity.Account;

public interface AccountRepo extends JpaRepositoryImplementation<Account, Integer>{

}
