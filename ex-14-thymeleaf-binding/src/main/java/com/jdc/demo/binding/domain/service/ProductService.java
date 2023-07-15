package com.jdc.demo.binding.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.demo.binding.domain.ShopBusinessException;
import com.jdc.demo.binding.domain.dto.form.ProductForm;
import com.jdc.demo.binding.domain.dto.vo.ProductDetailsVO;
import com.jdc.demo.binding.domain.dto.vo.ProductListVO;
import com.jdc.demo.binding.domain.dto.vo.PurchaseItemVO;
import com.jdc.demo.binding.domain.entity.Category;
import com.jdc.demo.binding.domain.entity.Product;
import com.jdc.demo.binding.domain.repo.CategoryRepo;
import com.jdc.demo.binding.domain.repo.ProductRepo;
import com.jdc.demo.binding.domain.repo.ShopRepo;
import com.jdc.demo.binding.domain.service.PhotoUploadService.Type;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
	
	private final ProductRepo repo;
	private final CategoryRepo categoryRepo;
	private final ShopRepo shopRepo;
	private final PhotoUploadService photoUploadService;

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

	public Optional<ProductDetailsVO> findDetailsById(int id) {
		return repo.findById(id).map(ProductDetailsVO::from);
	}

	public List<ProductListVO> search(Optional<Integer> category, Optional<String> keyword) {
		return repo.findAll(withCategory(category)
					.and(withKeyword(keyword)))
				.stream().map(ProductListVO::from).toList();
	}
	
	@Transactional(rollbackFor = ShopBusinessException.class)
	public void uploadPhoto(int id, MultipartFile ... files) {
		var photos = photoUploadService.upload(Type.Product, files);
		var product = repo.findById(id).orElseThrow();
		product.addImages(photos);
		
		if(!StringUtils.hasLength(product.getCoverImage()) && photos.size() > 0) {
			product.setCoverImage(photos.get(0));
		}
	}
	
	private Specification<Product> withCategory(Optional<Integer> data) {
		if(data.isPresent()) {
			return (root, query, cb) -> cb.equal(root.get("category").get("id"), data.get());
		}
		return Specification.where(null);
	}

	private Specification<Product> withKeyword(Optional<String> data) {
		if(data.isPresent()) {
			return (root, query, cb) -> cb.or(
					cb.like(cb.lower(root.get("name")), data.get().toLowerCase().concat("%")),
					cb.like(cb.lower(root.get("brand")), data.get().toLowerCase().concat("%")),
					cb.like(cb.lower(root.get("category").get("name")), data.get().toLowerCase().concat("%"))
			);
		}
		return Specification.where(null);
	}

	public ProductForm getFormById(Integer id) {
		return repo.findById(id).map(ProductForm::from).orElseThrow();
	}

	public List<PurchaseItemVO> getPurchaseItems(Map<Integer, Integer> items) {
		List<PurchaseItemVO> list = new ArrayList<>();
		
		for(var entry : items.entrySet()) {
			var vo = repo.findById(entry.getKey())
					.map(product -> PurchaseItemVO.from(product).quantity(entry.getValue()))
					.orElseThrow();
			list.add(vo);
		}
		
		return list;
	}


}
