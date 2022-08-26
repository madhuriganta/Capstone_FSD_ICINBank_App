package com.madhuri.icinbank.serviceImple;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhuri.icinbank.Exceptions.AccountNotFoundException;
import com.madhuri.icinbank.dao.PersonalTransactionsRepository;
import com.madhuri.icinbank.dao.SavingsAccountRepository;
import com.madhuri.icinbank.dao.UserRepository;
import com.madhuri.icinbank.model.PersonalTransactions;
import com.madhuri.icinbank.model.SavingsAccount;
import com.madhuri.icinbank.model.User;
import com.madhuri.icinbank.service.SavingsAccountService;
import com.madhuri.icinbank.service.UserService;

@Service
public class SavingsAccountServiceImple implements SavingsAccountService{

	@Autowired
	SavingsAccountRepository savingsRepo;
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	UserService userService;
	
	@Autowired
	private PersonalTransactionsRepository personalTransactionRepo;
	@Override
	public void deposit(String accno, int amount) {
		// TODO Auto-generated method stub
		SavingsAccount sAccount=savingsRepo.findByAccno(accno);
		int prevBal=sAccount.getBalance();
		int newBal=sAccount.getBalance()+amount;
		sAccount.setBalance(sAccount.getBalance()+amount);
		savingsRepo.save(sAccount);
		Date date=new Date();
		PersonalTransactions personalTransaction = new PersonalTransactions(accno , date, prevBal, newBal, "Deposit" ,"Savings");
		personalTransactionRepo.save(personalTransaction);
	}

	@Override
	public String withdraw(String accno, int amount) {
		// TODO Auto-generated method stub
		  SavingsAccount savingsAccount = savingsRepo.findByAccno(accno);
	  	    if(savingsAccount.getBalance()>=amount) {
	  	    	int prevBal = savingsAccount.getBalance();
	  	    	int newBal = savingsAccount.getBalance() - amount;
	  	    	savingsAccount.setBalance(newBal);
	  	    	savingsRepo.save(savingsAccount);
		            Date date = new Date();
			        PersonalTransactions personalTransaction = new PersonalTransactions(accno ,date, prevBal, newBal, "Withdraw" ,"Savings");
			        personalTransactionRepo.save(personalTransaction);
			        return "Done";
	  	    }
	  	    else {
	  	    	return "Insufficient balance";
	  	    }
		
	}

	@Override
	public void transfer(String saccount, String raccount, int amount) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public SavingsAccount createSavingsAccount(SavingsAccount account) throws Exception {
		
		// TODO Auto-generated method stub
		 System.out.print("account: "+ account);
		 User user = userService.fetchUserById(account.getUserid());
		 account.setUser(user);
		 savingsRepo.save(account);
		 return savingsRepo.findByAccno(account.getAccno());
		
	}

	@Override
	public List<SavingsAccount> getAllSavingsAccounts() {
		// TODO Auto-generated method stub
		return savingsRepo.findAll();
	}

	@Override
	public SavingsAccount getAccount(String accno) {
		// TODO Auto-generated method stub
		return savingsRepo.findByAccno(accno);
	}

	@Override
	public int retrieveAccountBalance(int accountId) {
		// TODO Auto-generated method stub
		Optional<SavingsAccount> account = savingsRepo.findById(accountId);
        if (!account.isPresent()) {
            throw new AccountNotFoundException(
                  String.format("Account %s not found.", accountId));
        }
        return account.get().getBalance();
	}

	@Override
	public List<SavingsAccount> getAllSavingsAccountByUserId(int id) {
		// TODO Auto-generated method stub
		return savingsRepo.findAllByCurrentSavingsUser(id);
	}
	


}
