package com.madhuri.icinbank.serviceImple;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhuri.icinbank.Exceptions.AccountNotFoundException;
import com.madhuri.icinbank.dao.PersonalTransactionsRepository;
import com.madhuri.icinbank.dao.PrimaryAccountRepository;
import com.madhuri.icinbank.dao.UserRepository;
import com.madhuri.icinbank.model.PersonalTransactions;
import com.madhuri.icinbank.model.PrimaryAccount;
import com.madhuri.icinbank.model.TransactionDetails;
import com.madhuri.icinbank.model.User;
import com.madhuri.icinbank.service.PrimaryAccountService;
import com.madhuri.icinbank.service.TransactionService;
import com.madhuri.icinbank.service.UserService;


@Service
public class PrimaryAccountServiceImple implements PrimaryAccountService {
	@Autowired
	 private PrimaryAccountRepository primaryAccountRepo;

	@Autowired
	UserRepository userRepo;
	@Autowired
	UserService userService;

	 @Autowired
	 private TransactionService transactionService;
	 
	 @Autowired
	 private PersonalTransactionsRepository personalTransactionRepo;
	 
	@Override
	public List<PrimaryAccount> getAllPrimaryAccounts() {
		// TODO Auto-generated method stub
		return primaryAccountRepo.findAll();
	}

	@Override
	public String withdraw(String accno, int amount) {
		// TODO Auto-generated method stub
		PrimaryAccount primaryAccount = primaryAccountRepo.findByAccno(accno);
		
		if(primaryAccount.getBalance()>=amount) {
			int prevBal = primaryAccount.getBalance();
			int newBal = primaryAccount.getBalance() - amount;
	        primaryAccount.setBalance(newBal);
	        primaryAccountRepo.save(primaryAccount);
	        Date date = new Date();
	        PersonalTransactions personalTransaction = new PersonalTransactions(accno ,date, prevBal, newBal, "Withdraw" ,"Primary");
	        personalTransactionRepo.save(personalTransaction);

	        return "Done";
		} else {
			return "Insufficient Balance";
		}
	}

	@Override
	public void deposit(String accno, int amount) {
		// TODO Auto-generated method stub
		PrimaryAccount primaryAccount = primaryAccountRepo.findByAccno(accno);
      	int prevBal = primaryAccount.getBalance();
      	int newBal = primaryAccount.getBalance() + amount;
        primaryAccount.setBalance(newBal );
        primaryAccountRepo.save(primaryAccount);
        Date date = new Date();
        PersonalTransactions personalTransaction = new PersonalTransactions(accno ,date, prevBal , newBal, "Deposit" ,"Primary");
        personalTransactionRepo.save(personalTransaction);
     
	}

	@Override
	public PrimaryAccount getAccount(String accno) {
		// TODO Auto-generated method stub
		return primaryAccountRepo.findByAccno(accno);
	}

	@Override
	public int retrieveAccountBalance(int accountId) {
		// TODO Auto-generated method stub
		Optional<PrimaryAccount> account = primaryAccountRepo.findById(accountId);
        if (!account.isPresent()) {
            throw new AccountNotFoundException(
                  String.format("Account %s not found.", accountId));
        }
        return account.get().getBalance();
	}

	@Override
	public TransactionDetails retrieveAccountBalanceAndListOfTransactions(String accno) {
		// TODO Auto-generated method stub
		PrimaryAccount account = primaryAccountRepo.findByAccno(accno);
        if (account==null) {
            throw new AccountNotFoundException(
                  String.format("Account %s not found.", accno));
        }
        TransactionDetails transactions = new TransactionDetails(
                        account.getAccno(), 
                        account.getBalance(), 
                        transactionService.retrieveTransactionsForAccount(accno));
        return transactions;
	}


	@Override
	public List<PrimaryAccount> getAllPrimaryAccountByUserId(int id) {
		// TODO Auto-generated method stub
		return primaryAccountRepo.findAllByCurrentPrimaryUserId(id);
	}

	// private static int balance=10000;
	@Override
	public PrimaryAccount createPrimaryAccount(PrimaryAccount account) throws Exception {
//		return account;
		 System.out.print("account: "+ account);
		 User user = userService.fetchUserById(account.getUserid());
		 account.setUser(user);
		 primaryAccountRepo.save(account);
		 return primaryAccountRepo.findByAccno(account.getAccno());
		
	}


	

}
