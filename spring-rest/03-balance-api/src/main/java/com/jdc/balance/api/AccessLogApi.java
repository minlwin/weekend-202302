package com.jdc.balance.api;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.balance.model.dto.AccessLogDto;
import com.jdc.balance.model.dto.response.ApiResponse;
import com.jdc.balance.model.dto.response.PageResult;
import com.jdc.balance.model.enums.AccessStatus;
import com.jdc.balance.service.AccessLogService;

@RestController
@RequestMapping("access")
public class AccessLogApi {
	
	@Autowired
	private AccessLogService service;

	@GetMapping
	@PreAuthorize("hasAuthority('Admin')")
	ApiResponse<PageResult<AccessLogDto>> findForAdmin(
			@RequestParam Optional<AccessStatus> status, 
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> from, 
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> to, 
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		return ApiResponse.from(service.search(status, from, to, page, pageSize));
	}
	
	
	@GetMapping("mine")
	ApiResponse<PageResult<AccessLogDto>> findForOwn(
			@RequestParam Optional<AccessStatus> status, 
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> from, 
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<LocalDate> to, 
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		return ApiResponse.from(service.searchForMe(status, from, to, page, pageSize));
	}

}
