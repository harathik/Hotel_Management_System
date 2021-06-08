package com.hotel.MicroService_Master.service;

import java.util.List;

import com.hotel.MicroService_Master.model.InventoryDto;

public interface InventoryService {
	  public String saveInventory(InventoryDto inventoryDto);
		
		public List<InventoryDto> getAllInventory();
		
		public InventoryDto findById(String id);
		
		public String deleteInventoryById(String id);

}
