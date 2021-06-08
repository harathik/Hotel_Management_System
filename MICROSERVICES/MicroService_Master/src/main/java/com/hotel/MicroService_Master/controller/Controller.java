package com.hotel.MicroService_Master.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.MicroService_Master.model.InventoryDto;
import com.hotel.MicroService_Master.model.ReturnResponse;
import com.hotel.MicroService_Master.service.InventoryService;

@CrossOrigin(exposedHeaders = {HttpHeaders.CONTENT_DISPOSITION})
@RestController
@RequestMapping("/hotel")
public class Controller {
	   
	   @Autowired
	   InventoryService inventoryServiceImpl;

	    @GetMapping(value = "/test")
	    public String testHm() {


	        return "microservice master setup!!";
	    }
	    
		
		
		@PostMapping(value = "/save/inventory")
		public ResponseEntity<String> saveInventory(@RequestBody InventoryDto inventoryDto) {
			
			return new ResponseEntity( new ReturnResponse(inventoryServiceImpl.saveInventory(inventoryDto)), HttpStatus.OK);
		}
	    @PutMapping(value = "/update/inventory")
	    public ResponseEntity<String> updateInventory(@RequestBody InventoryDto inventoryDto) {
	        Optional<InventoryDto> existing = Optional.ofNullable(inventoryServiceImpl.findById(inventoryDto.getId()));
	        if(existing.isPresent()){
	            String saved = inventoryServiceImpl.saveInventory(inventoryDto);
	            return new ResponseEntity(new ReturnResponse(saved), HttpStatus.OK);
	        }
	        return new ResponseEntity( new ReturnResponse("Category not found"), HttpStatus.OK);
	    }
		
		
		
		
		@GetMapping(value="/getAll/inventory")
	    public ResponseEntity<List<InventoryDto>> getAllInventory(){
			return new ResponseEntity(inventoryServiceImpl.getAllInventory(), HttpStatus.OK);
			
		}
		
		@GetMapping(value="/getinventory/byid/{id}")
	    public ResponseEntity<String> findInventoryById(@PathVariable String id){
			return new ResponseEntity(inventoryServiceImpl.findById(id), HttpStatus.OK);
			
		}
		
		@DeleteMapping(value="/deleteinventory/byid/{id}")
	    public ResponseEntity<String> deleteInventoryById(@PathVariable String id){
			String success=inventoryServiceImpl.deleteInventoryById(id);
			return new ResponseEntity(new ReturnResponse(success), HttpStatus.OK);
			
		}

		

}
