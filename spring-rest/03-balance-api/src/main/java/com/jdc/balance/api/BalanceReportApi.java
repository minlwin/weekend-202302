package com.jdc.balance.api;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.balance.model.dto.ApiResponse;
import com.jdc.balance.model.dto.PageResult;
import com.jdc.balance.model.dto.ReportForDay;
import com.jdc.balance.model.dto.ReportForMonth;

@RestController
@RequestMapping("balance")
public class BalanceReportApi {

	@GetMapping("{year}")
	ApiResponse<PageResult<ReportForMonth>> monthlyReport(
			@PathVariable int year, 
			@RequestParam Optional<Integer> ledger, 
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "0") int pageSize) {
		return null;
	}

	@GetMapping("{year}/{month}")
	ApiResponse<PageResult<ReportForDay>> dailyReport(
			@PathVariable int year, 
			@PathVariable int month, 
			@RequestParam Optional<Integer> ledger,
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "0") int pageSize) {
		return null;
	}
	
}
