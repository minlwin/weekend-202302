package com.jdc.location.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.model.dto.TownshipDTO;
import com.jdc.location.model.dto.form.TownshipForm;
import com.jdc.location.model.repo.DivisionRepo;
import com.jdc.location.model.repo.TownshipRepo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TownshipService {

	private final TownshipRepo townshipRepo;
	private final DivisionRepo divisionRepo;
	
	public TownshipDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public TownshipDTO create(TownshipForm form) {
		var entity = form.entity(divisionRepo::findById);
		entity = townshipRepo.save(entity);
		return TownshipDTO.from(entity);
	}

	@Transactional
	public TownshipDTO update(int id, TownshipForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TownshipDTO> search(Optional<String> region, Optional<Integer> division, Optional<String> keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
