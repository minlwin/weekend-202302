package com.jdc.balance.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdc.balance.model.dto.MemberDetailsDto;
import com.jdc.balance.model.dto.MemberListDto;
import com.jdc.balance.model.dto.PageResult;
import com.jdc.balance.model.enums.MemberRole;
import com.jdc.balance.model.enums.MemberStatus;
import com.jdc.balance.model.form.MemberForm;
import com.jdc.balance.model.form.MemberStatusForm;

@Service
public class MemberService {

	public PageResult<MemberListDto> search(Optional<MemberRole> role, Optional<MemberStatus> status, String keyword, int page,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public MemberDetailsDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int create(MemberForm form) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(int id, MemberForm form) {
		// TODO Auto-generated method stub
		return id;
	}

	public int updateStatus(int id, MemberStatusForm form) {
		// TODO Auto-generated method stub
		return id;
	}

}
