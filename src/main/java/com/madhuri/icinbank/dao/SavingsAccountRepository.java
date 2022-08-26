package com.madhuri.icinbank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.madhuri.icinbank.model.SavingsAccount;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount,Integer>{
	SavingsAccount findByAccno(String accno);

	@Query("From SavingsAccount s WHERE s.user.id = :user_Id ")
    List<SavingsAccount> findAllByCurrentSavingsUser(@Param("user_Id")int id);
}
