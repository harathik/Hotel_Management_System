package com.hotel.MicroService_Head.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.MicroService_Head.Repository.InventoryRepository;
import com.hotel.MicroService_Head.entity.Inventory;
import com.hotel.MicroService_Head.entity.Staff;
import com.hotel.MicroService_Head.model.InventoryDto;
import com.hotel.MicroService_Head.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	InventoryRepository inventoryRepository;
	
	public String saveInventory(InventoryDto invDto) {
		
		Inventory inventory = new Inventory(invDto.getId(),invDto.getName(), invDto.getQuantity(),invDto.getPrice());

		Inventory createInventory = inventoryRepository.save(inventory);
		
		return createInventory.getId();
	}
	
	
	public List<InventoryDto> getAllInventory(){
		
		List<Inventory> inventoryList= inventoryRepository.findAll();
		
		List<InventoryDto> result = new ArrayList<InventoryDto>();
		if(!inventoryList.isEmpty()) {
			for(Inventory s:inventoryList){
				InventoryDto invDto = new InventoryDto(s.getId(),s.getName(), s.getQuantity(),s.getPrice());
				result.add(invDto);
			}
		}
	return result;
	}
	
	public InventoryDto findById(String id) {
		
		InventoryDto invDto = null;
		Optional<Inventory> inventory = inventoryRepository.findById(id);
		
		if(inventory.isPresent()) {
			Inventory s =inventory.get();
			invDto = new InventoryDto(s.getId(),s.getName(), s.getQuantity(),s.getPrice());
		}
		
	    return invDto;	
	
	}
	
	public String deleteInventoryById(String id) {
		inventoryRepository.deleteById(id);
		return id;
	}


	@Override
	public String updateInventory(InventoryDto invDto) {
		
			Optional<Inventory> room = inventoryRepository.findById(invDto.getId());
			System.out.println("**************UPdating"+invDto.getId());
			Staff updatedStaff = null;
			if(room.isPresent()){
				Inventory inventory = new Inventory(invDto.getId(),invDto.getName(),invDto.getQuantity(),invDto.getPrice());

				inventoryRepository.save(inventory);
				return inventory.getId();
			}else{
				return "Unable to find employee";
			}
	
	}


}
