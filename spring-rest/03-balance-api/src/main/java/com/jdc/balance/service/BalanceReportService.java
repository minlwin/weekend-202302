package com.jdc.balance.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.balance.model.dto.ReportForDayDto;
import com.jdc.balance.model.dto.ReportForMonthDto;
import com.jdc.balance.model.entity.Member;
import com.jdc.balance.model.repo.TransactionRepo;

@Service
@Transactional(readOnly = true)
public class BalanceReportService {
	
	@Autowired
	private TransactionRepo repo;
	
	@Autowired
	private LoginUserService loginUserService;

	public List<ReportForMonthDto> searhMonthlyReport(int year, Optional<Integer> ledger, int page, int pageSize) {
		
		var result = new ArrayList<ReportForMonthDto>();
		var targetYear = Year.of(year);
		var targetMonth = targetYear.atMonth(Month.JANUARY);
		
		var loginUser = loginUserService.getLoginUser();
		
		while(targetMonth.isBefore(targetYear.atMonth(Month.JANUARY).plusYears(1))) {
			result.addAll(findForMonth(loginUser ,targetMonth));
			targetMonth = targetMonth.plusMonths(1);
		}
		
		return result;
	}

	private List<ReportForMonthDto> findForMonth(Member loginUser, YearMonth month) {
		return repo.findTransactionReport(loginUser.getId(), month.atDay(1), month.plusMonths(1).atDay(1))
				.stream().map(a -> ReportForMonthDto.from(month, a)).toList();
	}

	public List<ReportForDayDto> searchDailyReport(int year, int month, Optional<Integer> ledger, int page, int pageSize) {
		var result = new ArrayList<ReportForDayDto>();
		var yearMonth = YearMonth.of(year, month);
		var targetDate = yearMonth.atDay(1);
		var loginUser = loginUserService.getLoginUser();
		
		while(targetDate.isBefore(yearMonth.plusMonths(1).atDay(1))) {
			result.addAll(findForDay(loginUser, targetDate));
			targetDate = targetDate.plusDays(1);
		}
		
		return result;
	}
	
	private List<ReportForDayDto> findForDay(Member loginUser, LocalDate date) {
		return repo.findTransactionReport(loginUser.getId(), date, date.plusDays(1))
				.stream().map(a -> ReportForDayDto.from(date, a)).toList();
	}
}
