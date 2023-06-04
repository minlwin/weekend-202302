package com.jdc.registration.service.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.registration.service.entity.Registration;

public interface RegistrationRepo extends JpaRepositoryImplementation<Registration, Integer>{

}
