package com.jdc.demo.binding.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.binding.domain.dto.vo.ProductListVO;
import com.jdc.demo.binding.domain.repo.ProductRepo;


@Service
@Transactional(readOnly = true)
public class ProductService {
	
	@Autowired
	private ProductRepo repo;

	public List<ProductListVO> findByShop(int id) {
		return repo.findByShopId(id)
				.map(ProductListVO::from).toList();
	}
}
