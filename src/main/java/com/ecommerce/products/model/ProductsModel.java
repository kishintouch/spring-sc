package com.ecommerce.products.model;

import java.math.BigInteger;

public class ProductsModel {

	
	private BigInteger Id ;
	private String productName;
	private String productPrice;
	private String productDescription;
	private String productCatageory;
	private String productModel;
	public BigInteger getId() {
		return Id;
	}
	public void setId(BigInteger id) {
		Id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
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
	
	
}
