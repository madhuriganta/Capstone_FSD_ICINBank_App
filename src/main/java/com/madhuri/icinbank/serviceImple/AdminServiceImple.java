package com.madhuri.icinbank.serviceImple;

import java.util.List;
import java.util.Optional;

import com.madhuri.icinbank.model.User;
import com.madhuri.icinbank.service.AdminService;

public class AdminServiceImple implements AdminService{

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> getUserById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
	
//	@Autowired
//	AdminRepo adminRepo;
//
//	@Override
//	public List<User> getAllUsers() {
//		// TODO Auto-generated method stub
//		return adminRepo.findAll();
//	}
//
//	@Override
//	public Optional<User> getUserById(int id) {
//		// TODO Auto-generated method stub
//		return adminRepo.findById(id);
//	}
//
//	@Override
//	public void deleteById(int id) {
//		// TODO Auto-generated method stub
////		adminRepo.deleteById(adminRepo.findById(id));
//		adminRepo.deleteById(id);
//	}
//

}
