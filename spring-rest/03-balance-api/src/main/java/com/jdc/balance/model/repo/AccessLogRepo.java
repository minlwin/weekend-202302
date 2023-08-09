package com.jdc.balance.model.repo;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.balance.model.entity.AccessLog;

public interface AccessLogRepo extends JpaRepositoryImplementation<AccessLog, Long>{

	@Query("select max(a.access) from AccessLog a where a.username = ?1")
	LocalDateTime findLatestAccessForUser(String username);
}
