package com.madhuri.icinbank.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madhuri.icinbank.model.User;



@Repository
public interface AdminRepo extends JpaRepository<User,Integer> {

	public User findById(int id);

}
