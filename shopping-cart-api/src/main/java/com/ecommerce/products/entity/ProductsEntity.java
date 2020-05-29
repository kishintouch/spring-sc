package com.ecommerce.products.entity;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.ecommerce.cart.entity.CartEntity;
import com.ecommerce.common.BaseEntity;


@Entity
@Table(name="products")
public class ProductsEntity extends BaseEntity {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "bigint(20)")
	private BigInteger Id ;
	
	private String productName;
	private BigInteger productPrice;
	private String productDescription;
	private String productCatageory;
	private String productModel;
	
	@OneToOne(fetch = FetchType.LAZY ,cascade=CascadeType.ALL)
	 @JoinColumn(name="product_id")
	private CartEntity cart;
	
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
	public CartEntity getCart() {
		return cart;
	}
	public void setCart(CartEntity cart) {
		this.cart = cart;
	}

	
	
	
	
}
