package com.madhuri.icinbank.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersonalTransactions {
	@Id
	@GeneratedValue
	private int transactionId;
	private String accno;
	private Date date;
	private int prevBalance;
	private int newBalance;
	private String transactionType;
	private String accType;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPrevBalance() {
		return prevBalance;
	}
	public void setPrevBalance(int prevBalance) {
		this.prevBalance = prevBalance;
	}
	public int getNewBalance() {
		return newBalance;
	}
	public void setNewBalance(int newBalance) {
		this.newBalance = newBalance;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public PersonalTransactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonalTransactions(String accNo, Date date, int prevBalance, int newBalance,
			String transactionType, String accType) {
		super();
		this.accno = accNo;
		this.date = date;
		this.prevBalance = prevBalance;
		this.newBalance = newBalance;
		this.transactionType = transactionType;
		this.accType = accType;
	}
	
}
