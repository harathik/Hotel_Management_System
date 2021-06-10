package com.hotel.MicroService_Head.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.MicroService_Head.model.InventoryDto;
import com.hotel.MicroService_Head.model.ReturnResponse;
import com.hotel.MicroService_Head.model.StaffDto;
import com.hotel.MicroService_Head.service.InventoryService;
import com.hotel.MicroService_Head.service.StaffService;


@RestController
@RequestMapping("/hotel")
public class Controller {
	   
	   @Autowired
	   InventoryService inventoryServiceImpl;
	   
	   @Autowired
	   StaffService staffServiceImpl;
	   

	    @GetMapping(value = "/test")
	    public String testHm() {


	        return "microservice master setup!!";
	    }
	    
		
		
		@PostMapping(value = "/save/inventory")
		public String saveInventory(@RequestBody InventoryDto inventoryDto) {
			
			return (inventoryServiceImpl.saveInventory(inventoryDto));
		}
	    @PutMapping(value = "/update/inventory")
	    public  ReturnResponse updateInventory(@RequestBody InventoryDto inventoryDto) {
	        Optional<InventoryDto> existing = Optional.ofNullable(inventoryServiceImpl.findById(inventoryDto.getId()));
	        if(existing.isPresent()){
	            String saved = inventoryServiceImpl.saveInventory(inventoryDto);
	            return new ReturnResponse(saved);
	        }
	        return new ReturnResponse("Category not found");
	    }
		@GetMapping(value="/getAll/inventory")
	    public List<InventoryDto> getAllInventory(){
			return inventoryServiceImpl.getAllInventory();
			
		}
		
		@GetMapping(value="/getinventory/byid/{id}")
	    public  InventoryDto findInventoryById(@PathVariable String id){
			return inventoryServiceImpl.findById(id);
			
		}
		
		@DeleteMapping(value="/deleteinventory/byid/{id}")
	    public  ReturnResponse deleteInventoryById(@PathVariable String id){
			String success=inventoryServiceImpl.deleteInventoryById(id);
			return new ReturnResponse(success);
			
		}
		
		
				@PostMapping(value = "/save/staff")
		public  String saveStaff(@RequestBody StaffDto staffDto) {
			return staffServiceImpl.saveStaff(staffDto);	
			}
				
				
				
		@GetMapping(value="/getAll/staff")
	    public List<StaffDto> getAllStaff(){
			return staffServiceImpl.getAllStaff();
		
		}
		
		@GetMapping(value="/getstaff/byid/{id}")
	    public  StaffDto findStaffById(@PathVariable String id){
			return staffServiceImpl.findById(id);
	
		}		
	@DeleteMapping(value="/deletestaff/byid/{id}")
	    public  ReturnResponse deleteStaffById(@PathVariable String id){
			String success=staffServiceImpl.deleteStaffById(id);
		return new ReturnResponse(success);
		}
	    @PutMapping(value = "/update/staff")
	    public  ReturnResponse updateStaff(@RequestBody StaffDto staffDto) {
	        Optional<StaffDto> existing = Optional.ofNullable(staffServiceImpl.findById(staffDto.getId()));
	        if(existing.isPresent()){
	            String saved = staffServiceImpl.saveStaff(staffDto);
	            return new ReturnResponse(saved);
	        }
	        return new ReturnResponse("cannot find employee or staff ");
	    }
	

}
