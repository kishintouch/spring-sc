package com.ecommerce.products.mapper;

import org.springframework.stereotype.Component;

import com.ecommerce.products.entity.ProductsEntity;
import com.ecommerce.products.model.ProductsModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductsMapper {
	
	
	public ProductsModel toProductModels(ProductsEntity entity){
		
		ProductsModel prodModel = new ProductsModel();
		return toProductModels(entity,prodModel);
		
	}
	
	public ProductsModel toProductModels(ProductsEntity entity,ProductsModel prodModel){
		prodModel.setId(entity.getId());
		prodModel.setProductPrice(entity.getProductPrice());
		prodModel.setProductCatageory(entity.getProductCatageory());
		prodModel.setProductDescription(entity.getProductDescription());
		prodModel.setProductModel(entity.getProductModel());
		prodModel.setProductName(entity.getProductName());
	
		return prodModel;
		
	}
	
   public List<ProductsModel> toProductModels(List<ProductsEntity> productEntities) {
        if (productEntities == null) {
            return new ArrayList<>();
        }

        List<ProductsModel> products = productEntities.stream().map(this::toProductModels).collect(Collectors.toList());

        return products;
    }
   
   public List<ProductsEntity> toProductEntity(List<ProductsModel> prodModels) {
       if (prodModels == null) {
           return new ArrayList<>();
       }

       List<ProductsEntity> products = prodModels.stream().map(this::toProductEntity).collect(Collectors.toList());

       return products;
   }
   
	public ProductsEntity toProductEntity(ProductsModel model, ProductsEntity entity) {
		entity.setId(model.getId());
		entity.setProductCatageory(model.getProductCatageory());
		entity.setProductDescription(model.getProductDescription());
		entity.setProductModel(model.getProductModel());
		entity.setProductName(model.getProductName());
		entity.setProductPrice(model.getProductPrice());
		
		return entity;

	}
	
	public ProductsEntity toProductEntity(ProductsModel model) {
		ProductsEntity prodEntity = new ProductsEntity();
		return toProductEntity(model, prodEntity);
	}

}
