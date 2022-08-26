package com.madhuri.icinbank.service;

import java.util.List;

import com.madhuri.icinbank.model.ChequeBookRequest;
import com.madhuri.icinbank.model.User;

public interface ChequeBookRequestService {

	public ChequeBookRequest createChequeBook(ChequeBookRequest chequebook,User user);
	public List<ChequeBookRequest> AllChequeBooks();
	public ChequeBookRequest findChequebookById(int id);
	public void ChequeBookRequestTrue(int id);
	public void ChequeBookRequestFalse(int id);
}
