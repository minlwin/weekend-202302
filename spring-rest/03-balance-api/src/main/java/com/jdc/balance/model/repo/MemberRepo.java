package com.jdc.balance.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.balance.model.entity.Member;

public interface MemberRepo extends JpaRepositoryImplementation<Member, Integer>{

}
