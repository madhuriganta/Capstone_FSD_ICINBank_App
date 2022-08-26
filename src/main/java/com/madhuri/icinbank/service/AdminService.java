package com.madhuri.icinbank.service;

import java.util.List;
import java.util.Optional;

import com.madhuri.icinbank.model.User;

public interface AdminService {
	
	public List<User> getAllUsers();
	public Optional<User> getUserById(int id); 

	public void deleteById(int id);

}
