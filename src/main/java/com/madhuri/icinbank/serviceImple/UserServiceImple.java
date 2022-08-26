package com.madhuri.icinbank.serviceImple;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhuri.icinbank.dao.UserRepository;
import com.madhuri.icinbank.model.User;
import com.madhuri.icinbank.service.UserService;

@Service
public class UserServiceImple implements UserService{

	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User fetchUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	@Override
	public User fetchUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public User fetchUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

	@Override
	public User fetchUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return userRepo.findByUsernameAndPassword(username, password);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return (List<User>) userRepo.findAll();
	}

	@Override
	public void enableUser(String username) {
		// TODO Auto-generated method stub
		User user = fetchUserByUsername(username);
        user.setEnabled(true);
        userRepo.save(user);
		
	}

	@Override
	public void disableUser(String username) {
		// TODO Auto-generated method stub
		 User user = fetchUserByUsername(username);
	        user.setEnabled(false);
	        System.out.println(user.isEnabled());
	        userRepo.save(user);
	        System.out.println(username + " is disabled.");
		
	}

	@Override
	public User fetchUserById(int id) throws Exception {
		
		//TODO Auto-generated method stub
		User user=null;
		try {
			if(id<=0) throw new Exception("User Id can not be negative or zero");
			user = userRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new Exception("User not found with Id: "+id);
		}
		return user;

	}

	

}
