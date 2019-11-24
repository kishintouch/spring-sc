package com.ecommerce.user.entity;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ecommerce.common.BaseEntity;


@Entity
@Table(name="user_details")
public class UserDetailsEntity extends BaseEntity {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger Id ;
	
	private String name;
	private String emailAddress;
	private int age;
	private String gender;
	private String deliveryAddress;
	private String billingAddress;
	
	 @OneToOne(fetch = FetchType.EAGER ,cascade=CascadeType.ALL)
	 @JoinColumn(name = "user_login_id")
	 private UserLoginEntity userloginEntity ;
	 
	public UserLoginEntity getUserloginEntity() {
		return userloginEntity;
	}
	public void setUserloginEntity(UserLoginEntity userloginEntity) {
		this.userloginEntity = userloginEntity;
	}
	public BigInteger getId() {
		return Id;
	}
	public void setId(BigInteger id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	
}
