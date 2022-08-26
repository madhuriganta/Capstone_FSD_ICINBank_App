package com.madhuri.icinbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madhuri.icinbank.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	public User findByEmail(String email);
	public User findByEmailAndPassword(String email, String password);
	public User findByUsername(String username);
	public User findByUsernameAndPassword(String email, String password);

}
