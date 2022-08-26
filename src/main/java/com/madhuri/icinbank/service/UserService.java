package com.madhuri.icinbank.service;

import java.util.List;
import java.util.Optional;

import com.madhuri.icinbank.model.User;

public interface UserService {

	public User saveUser(User user);
	public User fetchUserByEmail(String email); 
	public User fetchUserByEmailAndPassword(String email, String passWord);
	public User fetchUserByUsername(String username); 
	public User fetchUserByUsernameAndPassword(String username, String password);
	public List<User> findAllUser();
    void enableUser(String username);

    void disableUser(String username);
    public User fetchUserById(int id) throws Exception;
}
