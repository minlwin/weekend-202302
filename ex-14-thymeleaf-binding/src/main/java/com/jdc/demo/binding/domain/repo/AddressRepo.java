package com.jdc.demo.binding.domain.repo;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.binding.domain.entity.Address;

public interface AddressRepo extends JpaRepositoryImplementation<Address, Integer>{

	// select a from Address where a.account.name = ?1
	Stream<Address> findByAccountEmail(String username);

}
