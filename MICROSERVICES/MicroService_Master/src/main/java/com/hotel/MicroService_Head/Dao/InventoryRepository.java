package com.hotel.MicroService_Head.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.MicroService_Head.entity.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String>{

}

