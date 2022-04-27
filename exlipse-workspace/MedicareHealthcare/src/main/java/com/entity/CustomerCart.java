package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userId;
	private long cartId;
	
	public CustomerCart() {
		super();
	}

	public CustomerCart(Long id, Long userId, long cartId) {
		super();
		this.id = id;
		this.userId = userId;
		this.cartId = cartId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "CustomerCart [id=" + id + ", userId=" + userId + ", cartId=" + cartId + "]";
	}

	
}
