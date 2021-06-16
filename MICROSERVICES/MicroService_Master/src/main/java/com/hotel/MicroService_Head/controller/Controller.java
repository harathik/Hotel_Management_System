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

import com.hotel.MicroService_Head.Dto.InventoryDto;
import com.hotel.MicroService_Head.Dto.ReturnResponse;
import com.hotel.MicroService_Head.Dto.RoomDto;
import com.hotel.MicroService_Head.Dto.StaffDto;
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
	   
//	   @Autowired
//	   OwnerService ownerservice;
//	   
//	   @Autowired
//	   ManagerService managerservice;
//	   
//	   @Autowired
//	   ReceptionistService receptionistservice;
	   
	   

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
		
		
		
//		
//		@PostMapping(value = "/save/manager")
//		public String saveManager(@RequestBody ManagerDto managerdto) {
//			
//			return (managerservice.saveManager(managerdto));
//		}
//	    @PutMapping(value = "/update/manager")
//	    public  ReturnResponse updateManager(@RequestBody ManagerDto managerdto) {
//	        Optional<ManagerDto> existing = Optional.ofNullable(managerservice.findById(managerdto.getUsername()));
//	        if(existing.isPresent()){
//	            String created = managerservice.saveManager(managerdto);
//	            return new ReturnResponse(created);
//	        }
//	        return new ReturnResponse("manager details  not found");
//	    }
//		@GetMapping(value="/getAll/managers")
//	    public List<ManagerDto> getAllManager(){
//			return managerservice.getAllManager();
//			
//		}
//		
//		@GetMapping(value="/getmanager/byid/{username}")
//	    public  ManagerDto findManagerById(@PathVariable String username){
//			return managerservice.findById(username);
//			
//		}
//		
//		@DeleteMapping(value="/deletemanager/byid/{username}")
//	    public  ReturnResponse deleteManagerById(@PathVariable String username){
//			String success=managerservice.deleteManagerById(username);
//			return new ReturnResponse(success);
//			
//		}
//		
//		
//		
//		@PostMapping(value = "/save/owner")
//		public String saveOwner(@RequestBody OwnerDto ownerdto) {
//		
//			return (ownerservice.saveOwner(ownerdto));
//		}
//	    @PutMapping(value = "/update/owner")
//	    public  ReturnResponse updateOwner(@RequestBody OwnerDto ownerdto) {
//	        Optional<OwnerDto> existing = Optional.ofNullable(ownerservice.findById(ownerdto.getUsername()));
//	        if(existing.isPresent()){
//	            String created = ownerservice.saveOwner(ownerdto);
//	            return new ReturnResponse(created);
//	        }
//	        return new ReturnResponse("owner details  not found");
//	    }
//		@GetMapping(value="/getAll/Owners")
//	    public List<OwnerDto> getAllOwner(){
//			return ownerservice.getAllOwner();
//			
//		}
//		
//		@GetMapping(value="/getowner/byid/{username}")
//	    public  OwnerDto findOwnerById(@PathVariable String username){
//			return ownerservice.findById(username);
//			
//		}
//		
//		@DeleteMapping(value="/deleteowner/byid/{username}")
//	    public  ReturnResponse deleteOwnerById(@PathVariable String username){
//			String success=ownerservice.deleteOwnerById(username);
//			return new ReturnResponse(success);
//			
//		}
//		
//		
//		
//		
//		
//		
//		@PostMapping(value = "/save/receptionist")
//		public String saveReceptionist(@RequestBody ReceptionistDto receptionistdto) {
//			
//			return (receptionistservice.saveReceptionist(receptionistdto));
//		}
//	    @PutMapping(value = "/update/Receptionist")
//	    public  ReturnResponse updateReceptionist(@RequestBody ReceptionistDto receptionistdto) {
//	        Optional<ReceptionistDto> existing = Optional.ofNullable(receptionistservice.findById(receptionistdto.getUsername()));
//	        if(existing.isPresent()){
//	            String created = receptionistservice.saveReceptionist(receptionistdto);
//	            return new ReturnResponse(created);
//	        }
//	        return new ReturnResponse("Receptionist details  not found");
//	    }
//		@GetMapping(value="/getAll/Receptionist")
//	    public List<ReceptionistDto> getAllReceptionist(){
//			return receptionistservice.getAllReceptionist();
//			
//		}
//		
//		@GetMapping(value="/getReceptionist/byid/{username}")
//	    public  ReceptionistDto findReceptionistById(@PathVariable String username){
//			return receptionistservice.findById(username);
//			
//		}
//		
//		@DeleteMapping(value="/deleteReceptionist/byid/{username}")
//	    public  ReturnResponse deleteReceptionistById(@PathVariable String username){
//			String success=receptionistservice.deleteReceptionistById(username);
//			return new ReturnResponse(success);
//			
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
}
