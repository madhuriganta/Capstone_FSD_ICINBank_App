package com.madhuri.icinbank.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhuri.icinbank.dao.ChequeBookRequestRepository;
import com.madhuri.icinbank.model.ChequeBookRequest;
import com.madhuri.icinbank.model.User;
import com.madhuri.icinbank.service.ChequeBookRequestService;

@Service
public class ChequeBookRequestServiceImple implements  ChequeBookRequestService{

	@Autowired
	ChequeBookRequestRepository chequeBookRepo;
	
	@Override
	public ChequeBookRequest createChequeBook(ChequeBookRequest chequeBook, User user) {
		// TODO Auto-generated method stub
		chequeBook.setUser(user);
		return chequeBookRepo.save(chequeBook);
	}

	@Override
	public List<ChequeBookRequest> AllChequeBooks() {
		// TODO Auto-generated method stub
		return chequeBookRepo.findAll();
	}

	@Override
	public ChequeBookRequest findChequebookById(int id) {
		// TODO Auto-generated method stub
		return chequeBookRepo.getOne(id);
	}

	@Override
	public void ChequeBookRequestTrue(int id) {
		// TODO Auto-generated method stub
		ChequeBookRequest chequeBook=chequeBookRepo.getOne(id);
		chequeBook.setRequest_status(true);
		chequeBookRepo.save(chequeBook);
		
	}

	@Override
	public void ChequeBookRequestFalse(int id) {
		// TODO Auto-generated method stub
		ChequeBookRequest chequeBook=chequeBookRepo.getOne(id);
		chequeBook.setRequest_status(false);
		chequeBookRepo.save(chequeBook);
		
	}

}
