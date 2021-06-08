package com.hotel.MicroService_Master.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.MicroService_Master.entity.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String>{

}

