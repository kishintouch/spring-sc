package com.ecommerce.cart.model;

import java.math.BigInteger;
import java.util.List;
import java.lang.reflect.Field;


public class CartModel {

	private BigInteger Id ;
	private BigInteger userId ;
	private CartProductModel  cartProducts;
	public BigInteger getId() {
		return Id;
	}
	public void setId(BigInteger id) {
		Id = id;
	}

	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public CartProductModel getCartProducts() {
		return cartProducts;
	}
	public void setCartProducts(CartProductModel cartProducts) {
		this.cartProducts = cartProducts;
	}
	
}
