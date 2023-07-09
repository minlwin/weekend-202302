package com.jdc.demo.binding.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.binding.domain.dto.form.ProductForm;
import com.jdc.demo.binding.domain.dto.vo.ProductListVO;
import com.jdc.demo.binding.domain.entity.Category;
import com.jdc.demo.binding.domain.entity.Product;
import com.jdc.demo.binding.domain.repo.CategoryRepo;
import com.jdc.demo.binding.domain.repo.ProductRepo;
import com.jdc.demo.binding.domain.repo.ShopRepo;

import lombok.RequiredArgsConstructor;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepo repo;
	private final CategoryRepo categoryRepo;
	private final ShopRepo shopRepo;

	public List<ProductListVO> findByShop(int id) {
		return repo.findByShopId(id)
				.map(ProductListVO::from).toList();
	}
	
	@Transactional
	public int save(ProductForm form) {
		
		var category = categoryRepo.findOneByName(form.getCategory())
				.orElseGet(() -> {
					var entity = new Category();
					entity.setName(form.getCategory());
					return categoryRepo.save(entity);
				});
		
		if(form.getId() == 0) {
			var entity = new Product();
			entity.setName(form.getName());
			entity.setCategory(category);
			entity.setBrand(form.getBrand());
			entity.setPrice(form.getPrice());
			entity.setFeatures(form.getFeatures());
			
			var shop = shopRepo.findById(form.getShop()).orElseThrow();
			entity.setShop(shop);
			
			return repo.save(entity).getId();
		}
		
		return repo.findById(form.getId())
				.map(entity -> {
					entity.setName(form.getName());
					entity.setCategory(category);
					entity.setBrand(form.getBrand());
					entity.setPrice(form.getPrice());
					entity.setFeatures(form.getFeatures());
					return entity.getId();
				}).orElseThrow();
	}

	public List<ProductListVO> search(Optional<Integer> category, Optional<String> keyword) {
		return List.of();
	}
}
