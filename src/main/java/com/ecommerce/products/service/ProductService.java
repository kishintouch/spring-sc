package com.ecommerce.products.service;


import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ecommerce.products.entity.ProductsEntity;
import com.ecommerce.products.model.ProductsModel;
import com.ecommerce.products.repo.ProductsRepo;
import com.ecommerce.products.mapper.ProductsMapper;
import com.ecommerce.common.exception.*;
import java.util.List;

@Component
public class ProductService {
		
	@Autowired
	ProductsRepo productsRepo ;
	
	
	@Autowired
	ProductsMapper prodMapper ;
	
	
	public List<ProductsModel> getAllProducts(){
		List<ProductsEntity> productsEntitys =	productsRepo.findAll(); 
		List<ProductsModel> productModels = prodMapper.toProductModels(productsEntitys);
		return productModels;
	}
	
	public void save(ProductsModel prodModel) {
		ProductsEntity productsEntity = prodMapper.toProductEntity(prodModel);
		productsRepo.save(productsEntity);
	}
	
	public ProductsModel get(BigInteger  id) {
		ProductsEntity product = productsRepo.findById(id).orElseThrow(() -> new AppException(ProductError.PRODUCT_NOT_FOUND));
		ProductsModel locationModel = prodMapper.toProductModels(product);
		return locationModel;
	}
	
	
	public void update(BigInteger  id, ProductsModel prodModel) {
		ProductsEntity product = productsRepo.findById(id).orElseThrow(() -> new AppException(ProductError.PRODUCT_NOT_FOUND));
		product  = prodMapper.toProductEntity(prodModel, product);
		productsRepo.save(product);
	}
	
	public void delete(BigInteger id) {
		ProductsEntity product = productsRepo.findById(id).orElseThrow(() -> new AppException(ProductError.PRODUCT_NOT_FOUND));
		productsRepo.delete(product);
	}
	
	
}
