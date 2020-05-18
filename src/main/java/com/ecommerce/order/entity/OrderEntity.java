package com.ecommerce.order.entity;

import java.math.BigInteger;
import java.util.List;
import java.util.HashSet;
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


@Entity
@Table(name="order_place")
public class OrderEntity extends BaseEntity {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id ;
	private String ordertype ;
	private String orderDesc ;

	@OneToMany(mappedBy = "orderEntity" ,fetch = FetchType.EAGER )
	private List<OrderDetailsEntity> detailsEntities;

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

	public List<OrderDetailsEntity> getDetailsEntities() {
		return detailsEntities;
	}

	public void setDetailsEntities(List<OrderDetailsEntity> detailsEntities) {
		this.detailsEntities = detailsEntities;
	}
	
}
