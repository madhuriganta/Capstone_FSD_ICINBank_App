package com.madhuri.icinbank.model;

import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ChequeBookRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private Long accno;
	private String accType;
	private LocalTime date;
	private int no_of_pages;
	private boolean request_status;
	@ManyToOne
    @JoinColumn(name="user_id")
    private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getAccno() {
		return accno;
	}
	public void setAccno(Long accno) {
		this.accno = accno;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public LocalTime getDate() {
		return date;
	}
	public void setDate(LocalTime date) {
		this.date = date;
	}
	public int getNo_of_pages() {
		return no_of_pages;
	}
	public void setNo_of_pages(int no_of_pages) {
		this.no_of_pages = no_of_pages;
	}
	public boolean isRequest_status() {
		return request_status;
	}
	public void setRequest_status(boolean request_status) {
		this.request_status = request_status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "ChequeBookRequest [id=" + id + ", accno=" + accno + ", no_of_pages=" + no_of_pages + ", request_status="
				+ request_status + ", user=" + user + "]";
	}
	
	
}
