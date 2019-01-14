package com.wipro.dxp.inventory.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document
public class Inventory {

	@Id
	@ApiModelProperty(notes = "The database generated inventory ID")
    private String id;
	@ApiModelProperty(notes = "The product quantity")
    private String quantity;
	@ApiModelProperty(notes = "The SKU of the product in the inventory")
    private String sku;
	@ApiModelProperty(notes = "The cart list information")
    private List<CartItem> cartList = new ArrayList<CartItem>();
	
	public String getId() {
		return id; 
	}

	public Inventory setId(String id) {
		this.id = id;
		return this;
	} 

	public String getQuantity() {
		return quantity;
	}

	public Inventory setQuantity(String quantity) {
		this.quantity = quantity;
		return this;
	}

	public List<CartItem> getCartList() {
		return cartList;
	}

	public Inventory setCartList(List<CartItem> cartList) {
		this.cartList = cartList;
		return this;
	}
	
	public String getSku() {
		return sku;
	}

	public Inventory setSku(String sku) {
		this.sku = sku;
		return this;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(id, inventory.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
