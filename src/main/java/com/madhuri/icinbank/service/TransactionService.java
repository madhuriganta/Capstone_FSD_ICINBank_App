package com.madhuri.icinbank.service;

import java.util.List;

import com.madhuri.icinbank.model.Transactions;


public interface TransactionService {
	 
	public void transferMoney(Transactions transaction);
	    
	public String retreiveAccountNumber(int id);

	public List<Transactions> retrieveTransactionsForAccount(String accno);

//	List<Transactions> getAllTransactions(String accno);
	public Transactions addAction(String saccount, String raccount, int amount);

}
