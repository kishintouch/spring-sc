package com.ecommerce.cart.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.cart.entity.CartEntity;
import com.ecommerce.cart.model.CartModel;
import com.ecommerce.cart.model.CartProductModel;
import com.ecommerce.cart.repo.CartRepo;
import com.ecommerce.common.exception.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;
import com.ecommerce.user.entity.*;
import com.ecommerce.user.repo.UserDetailsRepo;
import com.ecommerce.products.entity.*;
import com.ecommerce.products.repo.ProductsRepo;

@Component
public class CartMapper {

	@Autowired
	UserDetailsRepo userRepo;

	@Autowired
	ProductsRepo productsRepo;

	@Autowired
	CartRepo cartRepo;

	public CartModel toCartModels(CartEntity entity) {

		CartModel model = new CartModel();
		return toCartModels(entity, model);

	}

	public CartModel toCartModels(CartEntity entity, CartModel model) {
		model.setId(entity.getId());
		model.setUserId(entity.getUserDetails().getId());
		CartProductModel cartProductModel = new CartProductModel();
		cartProductModel.setProductId(entity.getProdEntity().getId());
		cartProductModel.setProductCatageory(entity.getProdEntity().getProductCatageory());
		cartProductModel.setProductDescription(entity.getProdEntity().getProductDescription());
		cartProductModel.setProductModel(entity.getProdEntity().getProductModel());
		cartProductModel.setProductName(entity.getProdEntity().getProductName());
		cartProductModel.setProductPrice(entity.getProdEntity().getProductPrice());
		cartProductModel.setQuantity(entity.getQuantity());

		model.setCartProducts(cartProductModel);

		return model;

	}

	public List<CartModel> toCartModels(List<CartEntity> cartEntities) {
		if (cartEntities == null) {
			return new ArrayList<>();
		}

		List<CartModel> products = cartEntities.stream().map(this::toCartModels).collect(Collectors.toList());

		return products;
	}

	public List<CartEntity> toCartEntity(List<CartModel> models) {
		if (models == null) {
			return new ArrayList<>();
		}

		List<CartEntity> carts = models.stream().map(this::toCartEntity).collect(Collectors.toList());

		return carts;
	}

	public CartEntity toCartEntity(CartModel model, CartEntity entity) {

		entity.setId(model.getId());
		UserDetailsEntity userDetail = userRepo.getUserByLoginId(model.getUserId().longValue());
		entity.setUserDetails(userDetail);

		ProductsEntity prodEntity = productsRepo.findById(model.getCartProducts().getProductId())
				.orElseThrow(() -> new AppException(ProductError.PRODUCT_NOT_FOUND));
		;
	
		entity.setProdEntity(prodEntity);
		
		BigInteger qty = entity.getQuantity();
		if(qty != null) {
			qty = qty.add(model.getCartProducts().getQuantity() );
		}else {
			qty = model.getCartProducts().getQuantity();
		}
		entity.setQuantity(qty);

		return entity;

	}

	public CartEntity toCartEntity(CartModel model) {
		CartEntity entity = new CartEntity();
		return toCartEntity(model, entity);
	}

}
