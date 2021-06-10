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
import com.hotel.MicroService_Head.model.RoomDto;
import com.hotel.MicroService_Head.model.StaffDto;
import com.hotel.MicroService_Head.service.InventoryService;
import com.hotel.MicroService_Head.service.RoomService;
import com.hotel.MicroService_Head.service.StaffService;


@RestController
@RequestMapping("/hotel")
public class Controller {
	   
	   @Autowired
	   InventoryService inventoryServiceImpl;
	   
	   @Autowired
	   StaffService staffServiceImpl;
	   
	   @Autowired
	   RoomService roomServiceImpl;
	   

	    @GetMapping(value = "/test")
	    public String testHm() {


	        return "microservice head setup!!";
	    }
	    
		
		
		@PostMapping(value = "/save/inventory")
		public String saveInventory(@RequestBody InventoryDto invDto) {
			
			return (inventoryServiceImpl.saveInventory(invDto));
		}
	    @PutMapping(value = "/update/inventory")
	    public  ReturnResponse updateInventory(@RequestBody InventoryDto invDto) {
	        Optional<InventoryDto> existing = Optional.ofNullable(inventoryServiceImpl.findById(invDto.getId()));
	        if(existing.isPresent()){
	            String created = inventoryServiceImpl.saveInventory(invDto);
	            return new ReturnResponse(created);
	        }
	        return new ReturnResponse("Inventory not found");
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
	    @PutMapping(value = "/updatestaff")
	    public  ReturnResponse updateStaff(@RequestBody StaffDto staffDto) {
	        Optional<StaffDto> existing = Optional.ofNullable(staffServiceImpl.findById(staffDto.getId()));
	        if(existing.isPresent()){
	            String created = staffServiceImpl.saveStaff(staffDto);
	            return new ReturnResponse(created);
	        }
	        return new ReturnResponse("cannot find employee or staff ");
	    }
	
	    @PostMapping(value = "/save/room")
		public String saveRoom(@RequestBody RoomDto roomDto) {
			
			return roomServiceImpl.saveRoom(roomDto);
		}
	    @PutMapping(value = "/update/room")
		public ReturnResponse updateRoom(@RequestBody RoomDto roomDto) {


			return  new ReturnResponse(roomServiceImpl.updateRoom(roomDto));
		}
	    @GetMapping(value="/getAll/rooms")
	    public List<RoomDto> getAllRooms(){
			return roomServiceImpl.getAllRooms();
			
		}
	    @GetMapping(value="/getroom/byid/{id}")
	    public  RoomDto findRoomById(@PathVariable String id){
			return roomServiceImpl.findById(id);
			
		}
		
		@DeleteMapping(value="/deleteroom/byid/{id}")
	    public  ReturnResponse deleteRoomById(@PathVariable String id){
			String success=roomServiceImpl.deleteRoomById(id);
			return new ReturnResponse(success);
			
		}
}
