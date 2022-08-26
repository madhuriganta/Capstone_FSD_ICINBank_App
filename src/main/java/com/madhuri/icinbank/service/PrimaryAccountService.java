package com.madhuri.icinbank.service;

import java.util.List;

import com.madhuri.icinbank.model.PrimaryAccount;
import com.madhuri.icinbank.model.TransactionDetails;

public interface PrimaryAccountService {

	public PrimaryAccount createPrimaryAccount(PrimaryAccount account) throws Exception  ;
	public List<PrimaryAccount> getAllPrimaryAccounts();
	public String withdraw(String accno, int amount);
	public void deposit(String accno, int amount);
	public PrimaryAccount getAccount(String accno);
    public int retrieveAccountBalance(int accountId);
    public TransactionDetails retrieveAccountBalanceAndListOfTransactions(String accno);
    public List<PrimaryAccount> getAllPrimaryAccountByUserId(int id);
   
}
