package com.ecommerce.cart.service;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.ecommerce.cart.comparator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Collections;
import com.ecommerce.cart.entity.CartEntity;
import com.ecommerce.cart.mapper.CartMapper;
import com.ecommerce.cart.model.*;
import com.ecommerce.cart.repo.CartRepo;
import com.ecommerce.common.exception.AppException;
import com.ecommerce.common.exception.*;
import com.ecommerce.common.exception.ProductError;
import com.ecommerce.products.entity.ProductsEntity;
import com.ecommerce.products.repo.ProductsRepo;
import com.ecommerce.user.entity.UserDetailsEntity;
import com.ecommerce.user.repo.UserDetailsRepo;

@Component
public class CartService {
		
	@Autowired
	CartRepo cartRepo ;
	
	@Autowired
	UserDetailsRepo userRepo ;
	
	@Autowired
	ProductsRepo productsRepo ;
	
	@Autowired
	CartMapper cartMapper ;
	
	@Autowired
	CartPriceCompare cartpriceComparator;
	
	public List<CartModel> getAllCarts(){
		List<CartEntity> entity =	cartRepo.findAll(); 
		List<CartModel> productModels = cartMapper.toCartModels(entity);
		return productModels;
	}
	
	public List<CartProductModel> getCartProducts(BigInteger userId){
		List<CartEntity> entities =	 cartRepo.getCartDetailsByUser(userId.longValue());
		
		List<CartProductModel> cartProductModels = new ArrayList<CartProductModel>();
		for(CartEntity entity : entities) {
			CartProductModel cartProductModel = new CartProductModel();
			cartProductModel.setProductId(entity.getProdEntity().getId());
			cartProductModel.setProductCatageory(entity.getProdEntity().getProductCatageory());
			cartProductModel.setProductDescription(entity.getProdEntity().getProductDescription());
			cartProductModel.setProductModel(entity.getProdEntity().getProductModel());
			cartProductModel.setProductName(entity.getProdEntity().getProductName());
			cartProductModel.setProductPrice(entity.getProdEntity().getProductPrice());
			cartProductModel.setQuantity(entity.getQuantity());
			cartProductModel.setCartId(entity.getId());
			
			cartProductModels.add(cartProductModel);
		}
		
		// Collections.sort(cartProductModels, Collections.reverseOrder(cartpriceComparator));
		 Collections.sort(cartProductModels, cartpriceComparator);
		
		return cartProductModels;
	}
	
	public void save(CartModel model) {
		if(model != null) {
			if(model.getUserId() != null && model.getCartProducts() != null && model.getCartProducts().getProductId() != null) {
				BigInteger userId = model.getUserId();
				BigInteger productId = model.getCartProducts().getProductId();
				CartEntity cartProductEntity = cartRepo.getProductByUser(userId, productId);
				//Check whether product is present in cart
				if(cartProductEntity != null && cartProductEntity.getId() != null) {
					BigInteger cartId = cartProductEntity.getId();
					cartProductEntity = cartMapper.toCartEntity(model, cartProductEntity);
					cartProductEntity.setId(cartId);
					cartRepo.save(cartProductEntity);
				}else {
					CartEntity entity = cartMapper.toCartEntity(model);
					cartRepo.save(entity);	
				}
			}
		}
			
	}
	
	public CartModel get(BigInteger  id) {
		CartEntity product = cartRepo.findById(id).orElseThrow(() -> new AppException(ProductError.PRODUCT_NOT_FOUND));
		CartModel locationModel = cartMapper.toCartModels(product);
		return locationModel;
	}
	
	
	public void update(BigInteger  id, CartModel model) {
		CartEntity cart = cartRepo.findById(id).orElseThrow(() -> new AppException(ProductError.PRODUCT_NOT_FOUND));
		cart  = cartMapper.toCartEntity(model, cart);
		cartRepo.save(cart);
	}
	
	public void updateCartQuantity(BigInteger  cartId, CartModel model) {
		CartEntity cartEntity = cartRepo.findById(cartId).orElseThrow(() -> new AppException(ProductError.PRODUCT_NOT_FOUND));
		cartEntity.setQuantity(model.getCartProducts().getQuantity());
		cartRepo.save(cartEntity);
	}
	
	public void delete(BigInteger id) {
		CartEntity cart = cartRepo.findById(id).orElseThrow(() -> new AppException(ProductError.PRODUCT_NOT_FOUND));
		cartRepo.delete(cart);
	}
	
	public void deleteCartByUserId(BigInteger userId) {
		List<CartEntity> entities =	 cartRepo.getCartDetailsByUser(userId.longValue());
		cartRepo.deleteAll(entities);
	}
	
}
