package com.madhuri.icinbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhuri.icinbank.dao.AdminRepo;
import com.madhuri.icinbank.model.User;

@Service
public class AdminService1 {
	
	@Autowired
	AdminRepo repo;

	public List<User> getAllUsers(){
		return (List<User>) repo.findAll();
		
	}
	
	public User getUserById( int id) {
		return repo.findById(id);
		
	}
	
	public void deleteById(int id) {
		repo.delete(repo.findById(id));
		
	}	
	
}
