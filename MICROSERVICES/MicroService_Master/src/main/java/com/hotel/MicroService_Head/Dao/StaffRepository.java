package com.hotel.MicroService_Head.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.MicroService_Head.entity.Staff;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String>{

}
