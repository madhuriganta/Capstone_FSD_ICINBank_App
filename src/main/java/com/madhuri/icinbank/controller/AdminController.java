package com.madhuri.icinbank.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.madhuri.icinbank.Exceptions.ResourceNotFoundException;
import com.madhuri.icinbank.model.PrimaryAccount;
import com.madhuri.icinbank.model.SavingsAccount;
import com.madhuri.icinbank.model.Transactions;
import com.madhuri.icinbank.model.User;
import com.madhuri.icinbank.service.AdminService1;
import com.madhuri.icinbank.service.PrimaryAccountService;
import com.madhuri.icinbank.service.SavingsAccountService;
import com.madhuri.icinbank.service.TransactionService;

@RestController
@CrossOrigin("*")
public class AdminController {
	
	@Autowired
	AdminService1 adminService;
	@Autowired
	TransactionService transactionService;
	@Autowired
	PrimaryAccountService primaryAccountService;
	
	@Autowired
	SavingsAccountService savingsAccService;
	
	
    @GetMapping("/getAllUsers")
	public List<User> getAllUsers() throws Exception
	{
			
			return adminService.getAllUsers();
	}
	
	
	@GetMapping("/admin/getuser/{id}")
	public User getuser(@PathVariable("id") int id) throws ResourceNotFoundException{
		User user;
		try {
			user=adminService.getUserById(id);
			return user;
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("User not found for this id :: " + id);
		
		}
	}
	@DeleteMapping("/admin/deleteuser/{id}")
	public void deleteuser(@PathVariable("id") int id) throws ResourceNotFoundException
	{
		try {
			adminService.deleteById(id);
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("User not found for this id :: " + id);
			
		}
			
	}
	
//	@GetMapping("/accounts/{accountId}/transactions")
//        public List<Transactions> retrieveAccountTransactions(@PathVariable String accno) {
//        //PrimaryAccount account = primaryAccountDao.findByAccountNumber(accountId);
//		/*
//		 * if (!account.isPresent()) { throw new AccountNotFoundException(
//		 * String.format("Account %s not found.", accountId)); }
//		 */
//        return transactionService.retrieveTransactionsForAccount(accno);
//    }
	@PostMapping("/creatPrimaryAccount")
	public PrimaryAccount newPrimaryAccount(@RequestBody PrimaryAccount account) throws Exception {
	
		
		return primaryAccountService.createPrimaryAccount(account);
	
	}
	@PostMapping("/creatSavingsAccount") 
	public SavingsAccount newSavingsAccount(@RequestBody SavingsAccount account) throws Exception {
	
		
		return savingsAccService.createSavingsAccount(account);
	
	}
	
	
	
	
	

}
