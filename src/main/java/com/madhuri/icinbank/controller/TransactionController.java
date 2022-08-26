package com.madhuri.icinbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.madhuri.icinbank.model.Transactions;
import com.madhuri.icinbank.service.TransactionService;

@RestController
@CrossOrigin("*")
public class TransactionController {
	
    @Autowired
    private TransactionService transactionService;
    
	@PostMapping("/transfer")
	public Object transferMoney(@RequestBody Transactions transaction) {

  	  transactionService.transferMoney(transaction);
       
       return transaction;
      

  }

}
