package com.ecommerce.order.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.ecommerce.user.entity.*;
import com.ecommerce.products.entity.*;
import com.ecommerce.common.BaseEntity;


@Entity
@Table(name="order_details")
public class OrderDetailsEntity extends BaseEntity {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "bigint(20)")
	private BigInteger id ;
	@Column(columnDefinition = "bigint(20)")
	private BigInteger productId ;
	@Column(columnDefinition = "bigint(20)")
	private BigInteger userId ;

	 @ManyToOne
	 @JoinColumn
	private OrderEntity orderEntity;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getProductId() {
		return productId;
	}

	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}
	
	
}
