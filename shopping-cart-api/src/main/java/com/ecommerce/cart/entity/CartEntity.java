package com.ecommerce.cart.entity;

import java.math.BigInteger;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.ecommerce.user.entity.*;
import com.ecommerce.products.entity.*;
import com.ecommerce.common.BaseEntity;


@Entity
@Table(name="cart")
public class CartEntity extends BaseEntity {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "bigint(20)")
	private BigInteger Id ;
	
	@Column(columnDefinition = "bigint(20)")
	private BigInteger quantity;

	 @OneToOne(fetch = FetchType.EAGER )
	 @JoinColumn(name = "user_id" ,columnDefinition = "bigint(20)")
	private UserDetailsEntity userDetails;
	
	 @OneToOne(fetch = FetchType.EAGER )
	 @JoinColumn(name = "cart",columnDefinition = "bigint(20)")
	private ProductsEntity prodEntity ;
	

	public BigInteger getQuantity() {
		return quantity;
	}
	public void setQuantity(BigInteger quantity) {
		this.quantity = quantity;
	}
	public UserDetailsEntity getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetailsEntity userDetails) {
		this.userDetails = userDetails;
	}
	public ProductsEntity getProdEntity() {
		return prodEntity;
	}
	public void setProdEntity(ProductsEntity prodEntity) {
		this.prodEntity = prodEntity;
	}
	public BigInteger getId() {
		return Id;
	}
	public void setId(BigInteger id) {
		Id = id;
	}
	
}
