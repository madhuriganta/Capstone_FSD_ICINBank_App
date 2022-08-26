package com.madhuri.icinbank.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class SavingsAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String accno;
	
	private int balance;
	
	private int userid;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn
	private User user;

	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SavingsAccount [id=" + id + ", accno=" + accno + ", balance=" + balance + ", userid=" + userid
				+ ", user=" + user + "]";
	}
	

}
