package com.hotel.MicroService_Head.service;

import java.util.List;

import com.hotel.MicroService_Head.model.RoomDto;

public interface RoomService {

	public String saveRoom(RoomDto roomDto);
	
	public String updateRoom(RoomDto roomDto);
	
	public List<RoomDto> getAllRooms();
	
    public RoomDto findById(String id);
	
	public String deleteRoomById(String id);
}

