package com.jdc.balance.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.balance.model.dto.AccessLogDto;
import com.jdc.balance.model.dto.response.PageResult;
import com.jdc.balance.model.entity.AccessLog;
import com.jdc.balance.model.enums.AccessStatus;
import com.jdc.balance.model.repo.AccessLogRepo;


@Service
@Transactional(readOnly = true)
public class AccessLogService {
	
	@Autowired
	private AccessLogRepo repo;
	
	@Autowired
	private LoginUserService loginUserService;

	public PageResult<AccessLogDto> search(Optional<AccessStatus> status, Optional<LocalDate> from, Optional<LocalDate> to, int page, int pageSize) {
		var pageParam = PageRequest.of(page, pageSize, Sort.by(Order.desc("access")));
		var result = repo.findAll(
				status(status).and(from(from)).and(to(to)), 
				pageParam);
		
		return PageResult.of(result.map(AccessLogDto::from));
	}

	public PageResult<AccessLogDto> searchForMe(Optional<AccessStatus> status, Optional<LocalDate> from, Optional<LocalDate> to,
			int page, int pageSize) {
		var pageParam = PageRequest.of(page, pageSize, Sort.by(Order.desc("access")));
		var result = repo.findAll(
				forMe().and(status(status)).and(from(from)).and(to(to)), 
				pageParam);
		return PageResult.of(result.map(AccessLogDto::from));
	}
	
	private Specification<AccessLog> forMe() {
		return (root, query, cb) -> cb.equal(root.get("username"), loginUserService.getLoginUser().getEmail());
	}
	

	private Specification<AccessLog> status(Optional<AccessStatus> input) {		
		if(input.isEmpty()) {
			return Specification.where(null);
		}
		return (root, query, cb) -> cb.equal(root.get("status"), input.get());
	}

	private Specification<AccessLog> from(Optional<LocalDate> input) {
		if(input.isEmpty()) {
			return Specification.where(null);
		}
		return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("access"), input.get().atStartOfDay());
	}

	private Specification<AccessLog> to(Optional<LocalDate> input) {
		if(input.isEmpty()) {
			return Specification.where(null);
		}
		return (root, query, cb) -> cb.lessThan(root.get("access"), input.get().plusDays(1).atStartOfDay());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void success(AuthenticationSuccessEvent event) {
		var authentication = event.getAuthentication();
		var log = new AccessLog();
		log.setStatus(AccessStatus.Success);
		log.setUsername(authentication.getName());
		repo.save(log);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void fails(AbstractAuthenticationFailureEvent event) {
		var authentication = event.getAuthentication();
		var log = new AccessLog();
		log.setStatus(AccessStatus.getStatus(event.getException()));
		log.setUsername(authentication.getName());
		repo.save(log);
	}

	public LocalDateTime findLastAccess(String email) {
		return repo.findLatestAccessForUser(email);
	}
}
