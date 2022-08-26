package com.madhuri.icinbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.madhuri.icinbank.model.ChequeBookRequest;
import com.madhuri.icinbank.model.User;
import com.madhuri.icinbank.service.ChequeBookRequestService;

@RestController
@CrossOrigin("*")
public class ChequeBookController {
	
	@Autowired
	ChequeBookRequestService cBService;

	@PostMapping("/createchequebook")
	public ChequeBookRequest createChequeBook(@RequestBody ChequeBookRequest chequebook) {
		System.out.println(chequebook);
		User user = chequebook.getUser();
//		int noOfPages = chequebook.getNo_of_pages();
		return cBService.createChequeBook(chequebook,user );
		
	}

	@GetMapping("/allcheques")
	public List<ChequeBookRequest> AllChequeBooks() {
		return cBService.AllChequeBooks();
	}

	@GetMapping("/getcheque/{id}")
	public ChequeBookRequest findChequebookById(@PathVariable("id") int id) {
		return cBService.findChequebookById(id);
	}

	@GetMapping("/admin/confirmchequetrue/{id}")
	public void ChequeBookRequestTrue(@PathVariable("id") int id) {
		cBService.ChequeBookRequestTrue(id);
		
	}

	@GetMapping("/admin/confirmchequefalse/{id}")
	public void ChequeBookRequestFalse(int id) {
		cBService.ChequeBookRequestFalse(id);
	}
	

}
