package com.madhuri.icinbank.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.madhuri.icinbank.Exceptions.InvalidAccountException;
import com.madhuri.icinbank.Exceptions.InvalidTransactionException;


@Entity
@Table
public class Transactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String saccount;
	private String raccount;
	private int amount;
	private LocalDate date;
	private String IFSC;
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSaccount() {
		return saccount;
	}
	public void setSaccount(String saccount) {
		this.saccount = saccount;
	}
	public String getRaccount() {
		return raccount;
	}
	public void setRaccount(String raccount) {
		this.raccount = raccount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(String saccount, String raccount, int amount, String iFSC) {
		super();
	    this.saccount = saccount;
		this.raccount = raccount;
		this.amount = amount;
		this.IFSC = iFSC;
	}
	
	@Override
	public String toString() {
		return "Transactions [saccount=" + saccount + ", raccount=" + raccount + ", amount=" + amount + ", IFSC=" + IFSC
				+ "]";
	}
	
//	public void runValidationTests(PrimaryAccount saccount, PrimaryAccount raccount) {
//	
//        int transactionAmount = getAmount();
//        
//        if (saccount ==null || raccount == null) {
//            throw new InvalidAccountException(
//                    String.format("Invalid source account %s "
//                            + "or destination account %s", 
//                            saccount.getAccno(),
//                            raccount.getAccno()));
//        }
//        if (transactionAmount<0) {
//            throw new InvalidTransactionException(
//                    String.format("Transaction %s is invalid"
//                            + " due to negative value", getId()));
//        }
//	}
	 @Override
	    public boolean equals(Object object) {
	        if (object == null || getClass() != object.getClass())
	            return false;
	        else if (this == object)
	            return true;

	        Transactions thisTransaction = (Transactions) object;
	        if (amount!=thisTransaction.amount)
	            return false;
	       
	        else if (saccount!=thisTransaction.saccount)
	            return false;
	        return raccount==thisTransaction.raccount;

	    }
}
