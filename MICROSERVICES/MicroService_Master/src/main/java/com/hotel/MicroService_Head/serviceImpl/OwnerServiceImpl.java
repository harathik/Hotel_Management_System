//package com.hotel.MicroService_Head.serviceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.hotel.MicroService_Head.Dao.OwnerRepository;
//import com.hotel.MicroService_Head.entity.Owner;
//import com.hotel.MicroService_Head.model.OwnerDto;
//
//@Service
//public class OwnerServiceImpl {
//	
//	@Autowired
//	OwnerRepository ownerRepository;
//	
//	public String saveOwner(OwnerDto ownerdto) {
//		
//		Owner owner = new Owner(ownerdto.getUsername(),ownerdto.getPassword());
//
//		Owner addowner = ownerRepository.save(owner);
//		
//		return addowner.getUsername();
//	}
//	
//	
//	public List<OwnerDto> getAllOwner(){
//		
//		List<Owner> ownerList= ownerRepository.findAll();
//		
//		List<OwnerDto> result = new ArrayList<OwnerDto>();
//		if(!ownerList.isEmpty()) {
//			for(Owner s:ownerList){
//				OwnerDto ownerdto = new OwnerDto(s.getUsername(),s.getPassword());
//				result.add(ownerdto);
//			}
//		}
//	return result;
//	}
//	
//	public OwnerDto findById(String username) {
//		
//		OwnerDto ownerdto = null;
//		Optional<Owner> owner = ownerRepository.findById(username);
//		
//		if(owner.isPresent()) {
//			Owner s =owner.get();
//			ownerdto = new OwnerDto(s.getUsername(),s.getPassword());
//		}
//		
//	    return ownerdto;	
//	
//	}
//	
//	public String deleteOwnerById(String username) {
//		ownerRepository.deleteById(username);
//		return username;
//	}
//
//
//	public String updateOwner(OwnerDto ownerdto) {
//		
//			Optional<Owner> x = ownerRepository.findById(ownerdto.getUsername());
//			System.out.println("**************UPdating"+ownerdto.getUsername());
//			if(x.isPresent()){
//				Owner owner = new Owner(ownerdto.getUsername(),ownerdto.getPassword());
//
//				ownerRepository.save(owner);
//				return owner.getUsername();
//			}else{
//				return "Unable to find owner";
//			}
//	
//	}
//
//}
