package com.jdc.balance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdc.balance.model.dto.LedgerDto;
import com.jdc.balance.model.enums.LedgerType;
import com.jdc.balance.model.form.LedgerForm;

@Service
public class LedgerService {

	public List<LedgerDto> search(Optional<LedgerType> type, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public int create(LedgerForm form) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(int id, LedgerForm form) {
		// TODO Auto-generated method stub
		return id;
	}

}
