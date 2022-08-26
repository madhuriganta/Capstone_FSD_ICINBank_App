package com.madhuri.icinbank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.madhuri.icinbank.model.PrimaryAccount;

@Repository
public interface PrimaryAccountRepository extends JpaRepository<PrimaryAccount,Integer>{
	 
	PrimaryAccount findByAccno (String accno);
	

	@Query("From PrimaryAccount p WHERE p.user.id = :user_Id ")
    List<PrimaryAccount> findAllByCurrentPrimaryUserId(@Param("user_Id") int id);

}
