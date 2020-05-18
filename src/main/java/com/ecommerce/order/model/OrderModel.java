package com.ecommerce.order.model;

import java.math.BigInteger;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
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
import com.ecommerce.order.entity.OrderDetailsEntity;


public class OrderModel  {
	

	private BigInteger id ;
	private String ordertype ;
	private String orderDesc ;
	private List<OrderDetailsModel> orderDetail;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public List<OrderDetailsModel> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetailsModel> orderDetail) {
		this.orderDetail = orderDetail;
	}

			
}
