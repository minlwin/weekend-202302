package com.jdc.balance.service;

import java.time.LocalDate;
import java.util.Optional;

import com.jdc.balance.model.dto.PageResult;
import com.jdc.balance.model.dto.TransactionDetailsDto;
import com.jdc.balance.model.dto.TransactionListDto;
import com.jdc.balance.model.enums.LedgerType;
import com.jdc.balance.model.form.TransactionForm;

public class TransactionService {

	public PageResult<TransactionListDto> search(Optional<LedgerType> type, Optional<LocalDate> from, Optional<LocalDate> to, String keyword,
			int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long create(TransactionForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long update(long id, TransactionForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	public TransactionDetailsDto findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
