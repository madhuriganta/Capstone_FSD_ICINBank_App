package com.madhuri.icinbank.model;

import java.util.List;

public class TransactionDetails {
	
	 private int id;
	 private String accno;
	 private int balance;
	 private List<Transactions> transactions;
	 
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public List<Transactions> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}
	public TransactionDetails(String accno, int balance, List<Transactions> transactions) {
		super();
		this.accno = accno;
		this.balance = balance;
		this.transactions = transactions;
	}
	
	  
	    

}
