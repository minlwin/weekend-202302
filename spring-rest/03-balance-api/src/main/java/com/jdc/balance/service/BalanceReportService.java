package com.jdc.balance.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdc.balance.model.dto.PageResult;
import com.jdc.balance.model.dto.ReportForDay;
import com.jdc.balance.model.dto.ReportForMonth;

@Service
public class BalanceReportService {

	public PageResult<ReportForMonth> searhMonthlyReport(int year, Optional<Integer> ledger, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageResult<ReportForDay> searchDailyReport(int year, int month, Optional<Integer> ledger, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
