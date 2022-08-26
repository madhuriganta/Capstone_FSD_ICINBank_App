package com.madhuri.icinbank.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.madhuri.icinbank.model.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions,Integer>{
    @Query("SELECT transactions FROM Transactions transactions "
            + "WHERE transactions.saccount = ?1"
            + "OR transactions.raccount = ?1")
    List<Transactions> retrieveTransactionsForAccount(String accno);
    public List<Transactions> findBySaccount(String saccount);
	public List<Transactions> findByRaccount(String raccount);
    

}
