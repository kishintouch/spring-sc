package com.ecommerce.cart.model;

import java.math.BigInteger;

public class CartProductModel {
	
	private BigInteger productId ;
	private String productName;
	private BigInteger productPrice;
	private String productDescription;
	private String productCatageory;
	private String productModel;
	private BigInteger quantity;
	private BigInteger cartId ;
	public BigInteger getProductId() {
		return productId;
	}
	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigInteger getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigInteger productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductCatageory() {
		return productCatageory;
	}
	public void setProductCatageory(String productCatageory) {
		this.productCatageory = productCatageory;
	}
	public String getProductModel() {
		return productModel;
	}
	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}
	public BigInteger getQuantity() {
		return quantity;
	}
	public void setQuantity(BigInteger quantity) {
		this.quantity = quantity;
	}
	public BigInteger getCartId() {
		return cartId;
	}
	public void setCartId(BigInteger cartId) {
		this.cartId = cartId;
	}
	

}
