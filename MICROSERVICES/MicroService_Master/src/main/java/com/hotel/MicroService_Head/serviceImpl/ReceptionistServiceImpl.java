//package com.hotel.MicroService_Head.serviceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.hotel.MicroService_Head.Dao.ReceptionistRepository;
//import com.hotel.MicroService_Head.entity.Receptionist;
//import com.hotel.MicroService_Head.model.ReceptionistDto;
//
//@Service
//public class ReceptionistServiceImpl {
//	@Autowired
//	ReceptionistRepository receptionistRepository;
//	
//	public String saveReceptionist(ReceptionistDto receptionistdto) {
//		
//		Receptionist receptionist = new Receptionist(receptionistdto.getUsername(),receptionistdto.getPassword());
//
//		Receptionist addreceptionist = receptionistRepository.save(receptionist);
//		
//		return addreceptionist.getUsername();
//	}
//	
//	
//	public List<ReceptionistDto> getAllInventory(){
//		
//		List<Receptionist> receptionistList= receptionistRepository.findAll();
//		
//		List<ReceptionistDto> result = new ArrayList<ReceptionistDto>();
//		if(!receptionistList.isEmpty()) {
//			for(Receptionist s:receptionistList){
//				ReceptionistDto receptionistdto = new ReceptionistDto(s.getUsername(),s.getPassword());
//				result.add(receptionistdto);
//			}
//		}
//	return result;
//	}
//	
//	public ReceptionistDto findById(String username) {
//		
//		ReceptionistDto receptionistdto = null;
//		Optional<Receptionist> receptionist = receptionistRepository.findById(username);
//		
//		if(receptionist.isPresent()) {
//			Receptionist s =receptionist.get();
//			receptionistdto = new ReceptionistDto(s.getUsername(),s.getPassword());
//		}
//		
//	    return receptionistdto;	
//	
//	}
//	
//	public String deleteReceptionistById(String username) {
//		receptionistRepository.deleteById(username);
//		return username;
//	}
//
//
//	public String updateReceptionist(ReceptionistDto receptionistdto) {
//		
//			Optional<Receptionist> x = receptionistRepository.findById(receptionistdto.getUsername());
//			System.out.println("**************UPdating"+receptionistdto.getUsername());
//			if(x.isPresent()){
//				Receptionist receptionist = new Receptionist(receptionistdto.getUsername(),receptionistdto.getPassword());
//
//				receptionistRepository.save(receptionist);
//				return receptionist.getUsername();
//			}else{
//				return "Unable to find receptionist";
//			}
//	
//	}
//
//}
