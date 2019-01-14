package com.wipro.dxp.inventory.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dxp.inventory.models.Inventory;
import com.wipro.dxp.inventory.repository.InventoryRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Inventory API", description="Inventory service API")
public class InventoryResource {

	@Autowired
	private InventoryRepository inventoryRepo;

	@ApiOperation(value = "Get all inventories")
	@GetMapping("/inventory")
	public List<Inventory> getInventory() {
		return inventoryRepo.findAll();
	}

	@ApiOperation(value = "Create an inventory")
	@PostMapping("/inventory")
	public String createInventory(@RequestBody Inventory inventory) {
		inventory = inventoryRepo.save(inventory);
		return inventory.getId();
	}

	/*@GetMapping("/inventory/{id}")
	public Optional<Inventory> getInventory(@PathVariable String id) {
		Optional<Inventory> inventory = inventoryRepo.findById(id);
		if (inventory == null) {
			throw new NotFoundException();
		} else {
			return inventory;
		}
	}*/

	@ApiOperation(value = "Search an inventory by SKU of the product")
	@GetMapping("/inventory/{sku}")
	public Inventory getInventoryBySku(@PathVariable String sku){
		Inventory inventory = inventoryRepo.findBySku(sku);
		if (inventory == null) {
			throw new NotFoundException();
		} else {
			return inventory;
		}
	}

	@ApiOperation(value = "Update an inventory")
	@PutMapping("/inventory/{id}")
	public void updateInventory(@RequestBody Inventory inventory,@PathVariable String id) {
		Optional<Inventory> inventoryOptional = inventoryRepo.findById(id);
		inventory.setId(id);
		inventoryRepo.save(inventory);
	}
	
	@ApiOperation(value = "Delete an inventory")
	@DeleteMapping("{id}")
	public void deleteInventory(@PathVariable String id) {
		Optional<Inventory> inventory = inventoryRepo.findById(id);
        if (inventory == null) {
            throw new NotFoundException();
        } else {
        	inventoryRepo.deleteById(id);
        }
        
    }
} 
