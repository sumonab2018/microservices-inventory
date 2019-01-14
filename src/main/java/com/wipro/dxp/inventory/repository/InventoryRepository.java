package com.wipro.dxp.inventory.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.dxp.inventory.models.Inventory;

/**
 * MongoDB repository for inventory.
 *
 * @author dxp
 */
public interface InventoryRepository extends MongoRepository<Inventory, String> {
	
	public Inventory findBySku(String sku);
}
