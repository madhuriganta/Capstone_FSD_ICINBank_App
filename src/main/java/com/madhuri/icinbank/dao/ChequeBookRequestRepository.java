package com.madhuri.icinbank.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madhuri.icinbank.model.ChequeBookRequest;

@Repository
public interface ChequeBookRequestRepository extends JpaRepository<ChequeBookRequest,Integer>{
	

}
