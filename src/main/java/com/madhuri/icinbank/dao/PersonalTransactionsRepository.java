package com.madhuri.icinbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madhuri.icinbank.model.PersonalTransactions;
@Repository
public interface PersonalTransactionsRepository extends JpaRepository<PersonalTransactions,Integer>{

}
