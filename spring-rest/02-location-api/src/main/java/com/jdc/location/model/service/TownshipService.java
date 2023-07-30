package com.jdc.location.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.model.LocationBusinessException;
import com.jdc.location.model.dto.TownshipDTO;
import com.jdc.location.model.dto.form.TownshipForm;
import com.jdc.location.model.entity.Township;
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
		return townshipRepo.findById(id).map(TownshipDTO::from)
				.orElseThrow(() -> new LocationBusinessException("There is no Township with id %d.".formatted(id)));
	}

	@Transactional
	public TownshipDTO create(TownshipForm form) {
		var entity = form.entity(divisionRepo::findById);
		entity = townshipRepo.save(entity);
		return TownshipDTO.from(entity);
	}

	@Transactional
	public TownshipDTO update(int id, TownshipForm form) {
		
		var entity = form.entity(divisionRepo::findById);
		
		return townshipRepo.findById(id).map(e -> {
			e.setName(form.name());
			e.setBurmese(form.burmese());
			e.setDivision(entity.getDivision());
			return TownshipDTO.from(e);
		})
		.orElseThrow(() -> new LocationBusinessException("There is no Township with id %d.".formatted(id)));
	}
	
	public List<TownshipDTO> search(Optional<String> region, Optional<Integer> division, Optional<String> keyword) {
		return townshipRepo.findAll(division(region, division).and(keyword(keyword)))
				.stream().map(TownshipDTO::from).toList();
	}
	
	private Specification<Township> division(Optional<String> region, Optional<Integer> division) {
		
		if(division.isPresent()) {
			return (root, query, cb) -> cb.equal(root.get("division").get("id"), division.get());
		}
		
		if(region.isPresent()) {
			return (root, query, cb) -> cb.equal(root.get("division").get("region"), region.get());
		}
		
		return Specification.where(null);
	}
	
	private Specification<Township> keyword(Optional<String> param) {
		
		if(param.isPresent()) {
			return (root, query, cb) -> cb.or(
				cb.like(cb.lower(root.get("name")), param.get().toLowerCase().concat("%")),
				cb.like(root.get("burmese"), param.get().concat("%"))
			);
		}
		
		return Specification.where(null);
	}
	
}
