//package com.hotel.MicroService_Head.serviceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.hotel.MicroService_Head.Dao.ManagerRepository;
//import com.hotel.MicroService_Head.entity.Manager;
//import com.hotel.MicroService_Head.model.ManagerDto;
//
//@Service
//public class ManagerServiceImpl {
//	@Autowired
//	ManagerRepository managerRepository;
//	
//	public String saveManager(ManagerDto managerdto) {
//		
//		Manager manager = new Manager(managerdto.getUsername(),managerdto.getPassword());
//
//		Manager addmanager = managerRepository.save(manager);
//		
//		return addmanager.getUsername();
//	}
//	
//	
//	public List<ManagerDto> getAllManager(){
//		
//		List<Manager> managerList= managerRepository.findAll();
//		
//		List<ManagerDto> result = new ArrayList<ManagerDto>();
//		if(!managerList.isEmpty()) {
//			for(Manager s:managerList){
//				ManagerDto managerdto = new ManagerDto(s.getUsername(),s.getPassword());
//				result.add(managerdto);
//			}
//		}
//	return result;
//	}
//	
//	public ManagerDto findById(String username) {
//		
//		ManagerDto managerdto = null;
//		Optional<Manager> manager = managerRepository.findById(username);
//		
//		if(manager.isPresent()) {
//			Manager s =manager.get();
//			managerdto = new ManagerDto(s.getUsername(),s.getPassword());
//		}
//		
//	    return managerdto;	
//	
//	}
//	
//	public String deleteManagerById(String username) {
//		managerRepository.deleteById(username);
//		return username;
//	}
//
//
//	public String updateManager(ManagerDto managerdto) {
//		
//			Optional<Manager> x = managerRepository.findById(managerdto.getUsername());
//			System.out.println("**************UPdating"+managerdto.getUsername());
//			if(x.isPresent()){
//				Manager manager = new Manager(managerdto.getUsername(),managerdto.getPassword());
//
//				managerRepository.save(manager);
//				return manager.getUsername();
//			}else{
//				return "Unable to find manager";
//			}
//	
//	}
//
//}
