package com.jdc.demo.binding.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.demo.binding.domain.dto.form.ShopForm;
import com.jdc.demo.binding.domain.dto.vo.IdWithName;
import com.jdc.demo.binding.domain.dto.vo.ShopListVO;
import com.jdc.demo.binding.domain.entity.Shop;
import com.jdc.demo.binding.domain.repo.AccountRepo;
import com.jdc.demo.binding.domain.repo.ShopRepo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShopService {
	
	private final ShopRepo repo;
	
	@Autowired
	private AccountRepo accountRepo;

	public ShopForm findFormById(Integer id) {
		return repo.findById(id).map(ShopForm::from).orElseThrow();
	}

	@Transactional
	public int save(ShopForm form) {

		if(form.getId() == 0) {
			// Create
			var entity = form.entity();

			// Get Login Id from Security Context
			var username = SecurityContextHolder.getContext().getAuthentication().getName();
			
			// Find User by login id
			var loginUser = accountRepo.findById(username).orElseThrow();
			
			// set user to entity
			entity.setOwner(loginUser);
			
			// save entity
			entity = repo.save(entity);
			
			// return id
			return entity.getId();
		}
		
		// find entity with id
		repo.findById(form.getId()).ifPresent(shop -> {
			// Set Name and greeting to entity
			shop.setName(form.getName());
			shop.setGreeting(form.getGreeting());
		});
		
		return form.getId();
	}

	public List<IdWithName<Integer>> findOnerShops() {
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		return repo.findByOwnerEmail(username)
				.map(IdWithName::from).toList();
	}
	
	public List<IdWithName<Integer>> findFavShops() {
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		return repo.findDistinctFirst10ByInvoiceInvoiceCustomerEmail(username)
				.map(IdWithName::from).toList();
	}
	

	public ShopListVO findInformation(int id) {
		return repo.findById(id)
				.map(ShopListVO::from).orElseThrow();
	}

	public List<ShopListVO> search(Optional<String> keyword) {
		return repo.findAll(whichKeyword(keyword)).stream()
				.map(ShopListVO::from).toList();
	}
	
	private Specification<Shop> whichKeyword(Optional<String> keyword) {
		
		if(keyword.filter(StringUtils::hasLength).isEmpty()) {
			return Specification.where(null);
		}
		
		// lower(s.name) like ?
		return (root, query, cb) -> cb.like(cb.lower(root.get("name")), 
				keyword.get().toLowerCase().concat("%"));
	}
}
