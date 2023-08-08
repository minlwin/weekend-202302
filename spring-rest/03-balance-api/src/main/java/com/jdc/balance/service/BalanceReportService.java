package com.jdc.balance.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdc.balance.model.dto.ReportForDayDto;
import com.jdc.balance.model.dto.ReportForMonthDto;
import com.jdc.balance.model.dto.response.PageResult;

@Service
public class BalanceReportService {

	public PageResult<ReportForMonthDto> searhMonthlyReport(int year, Optional<Integer> ledger, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageResult<ReportForDayDto> searchDailyReport(int year, int month, Optional<Integer> ledger, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
