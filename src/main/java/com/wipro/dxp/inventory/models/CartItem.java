package com.wipro.dxp.inventory.models;

public class CartItem {  

	private String cart_id;
	private Integer quantity;
	
	public String getCart_id() {
		return cart_id;
	}
	public CartItem setCart_id(String cart_id) {
		this.cart_id = cart_id;
		return this;
	}
	public Integer getQuantity() {
		return quantity; 
	}
	public CartItem setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this; 
	}
	
	
}
