package com.jdc.balance.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.balance.model.dto.ReportForDayDto;
import com.jdc.balance.model.dto.ReportForMonthDto;
import com.jdc.balance.model.dto.response.ApiResponse;
import com.jdc.balance.model.dto.response.PageResult;
import com.jdc.balance.service.BalanceReportService;

@RestController
@RequestMapping("balance")
public class BalanceReportApi {
	
	@Autowired
	private BalanceReportService service;

	@GetMapping("{year}")
	ApiResponse<PageResult<ReportForMonthDto>> monthlyReport(
			@PathVariable int year, 
			@RequestParam Optional<Integer> ledger, 
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "0") int pageSize) {
		return ApiResponse.from(service.searhMonthlyReport(year, ledger, page, pageSize));
	}

	@GetMapping("{year}/{month}")
	ApiResponse<PageResult<ReportForDayDto>> dailyReport(
			@PathVariable int year, 
			@PathVariable int month, 
			@RequestParam Optional<Integer> ledger,
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "0") int pageSize) {
		return ApiResponse.from(service.searchDailyReport(year, month, ledger, page, pageSize));
	}
	
}
