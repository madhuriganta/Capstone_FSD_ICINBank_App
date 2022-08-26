package com.madhuri.icinbank.service;

import java.util.List;

import com.madhuri.icinbank.model.SavingsAccount;

public interface SavingsAccountService {	
//	public SavingsAccount getAccountDetails(long accno);
//	public SavingsAccount getAccount(String username);
//	public SavingsAccount newAccount(String username,int userId);
	public void deposit(String accno,int amount);
	public String withdraw(String accno,int amount);
	public void transfer(String saccount,String raccount,int amount);
	
	public SavingsAccount createSavingsAccount(SavingsAccount account) throws Exception;
	public List<SavingsAccount> getAllSavingsAccounts();
	public SavingsAccount getAccount(String accno);
	public int retrieveAccountBalance(int accountId);
	public List<SavingsAccount>getAllSavingsAccountByUserId(int id);
}
