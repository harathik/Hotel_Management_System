package com.hotel.MicroService_Head.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.MicroService_Head.Dao.RoomRepository;
import com.hotel.MicroService_Head.entity.Room;
import com.hotel.MicroService_Head.model.RoomDto;
import com.hotel.MicroService_Head.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomRepository roomRepository;
	

	public String saveRoom(RoomDto roomDto) {

		Room room = new Room(roomDto.getId(),roomDto.getRoomNo(), roomDto.getFloor(), roomDto.getCategory(), roomDto.getCapacity(),
				roomDto.getPrice(),roomDto.isBooked());
		System.out.println("**************Booked"+roomDto.isBooked());

		Room savedRoom =  roomRepository.save(room);

		return savedRoom.getRoomNo();
	}
	public String updateRoom(RoomDto roomDto) {

		Optional<Room> room = roomRepository.findById(roomDto.getId());
		System.out.println("**************Booked"+roomDto.isBooked());
		Room savedRoom = null;
		if(room.isPresent()){
			savedRoom =  roomRepository.save(new Room(roomDto.getId(),roomDto.getRoomNo(), roomDto.getFloor(), roomDto.getCategory(), roomDto.getCapacity(),
					roomDto.getPrice(),roomDto.isBooked()));
			return savedRoom.getRoomNo();
		}else{
			return "Unable to find Room";
		}

	}
	
	public boolean isWithinRange(Date testDate,Date startDate, Date endDate) {

		return testDate.getTime() >= startDate.getTime() &&
				testDate.getTime() <= endDate.getTime();
	}
	
	public List<RoomDto> getAllRooms(){
		
		List<Room> roomsList = roomRepository.findAll();
		
		List<RoomDto> result = new ArrayList<RoomDto>();
		
		for(Room room:roomsList) {
			RoomDto roomDto = new RoomDto(room.getId(),room.getRoomNo(),room.getFloor(),room.getCategory(),room.getCapacity(),room.getPrice(),room.isBooked());
			result.add(roomDto);
		}
		
		return result;
	}
	
	 public RoomDto findById(String id) {
		 
		    RoomDto roomDto = null;
			Optional<Room> room = roomRepository.findById(id);
			
			if(room.isPresent()) {
				Room s =room.get();
				roomDto = new RoomDto(s.getId(),s.getRoomNo(),s.getFloor(),s.getCategory(),s.getCapacity(),s.getPrice(),s.isBooked());
			}
			
		    return roomDto;
	 }
		
		public String deleteRoomById(String id) {
			roomRepository.deleteById(id);
			return "test";
		}

}
