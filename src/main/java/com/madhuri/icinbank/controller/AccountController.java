package com.madhuri.icinbank.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.madhuri.icinbank.dao.PrimaryAccountRepository;
import com.madhuri.icinbank.dao.SavingsAccountRepository;
import com.madhuri.icinbank.model.PrimaryAccount;
import com.madhuri.icinbank.model.SavingsAccount;
import com.madhuri.icinbank.model.TransactionDetails;
import com.madhuri.icinbank.model.Transactions;
import com.madhuri.icinbank.service.PrimaryAccountService;
import com.madhuri.icinbank.service.SavingsAccountService;
import com.madhuri.icinbank.service.TransactionService;


@CrossOrigin("*")
@RestController
public class AccountController {
	
	@Autowired
	private PrimaryAccountService paService;
	@Autowired
	private SavingsAccountService saService;
	
	@Autowired
	private PrimaryAccountRepository primaryAccRepo;
	@Autowired
	private SavingsAccountRepository savingsAccRepo;

//	@Autowired
//	private UserService userService;
	
	

	@GetMapping("/deposit/{accType}/{accno}/{amount}" )
	public Object deposit(@PathVariable String accType, @PathVariable String accno, @PathVariable int amount) {
	
		if(accType.equals("Primary")) {
			System.out.println(accType);
			paService.deposit(accno , amount);
			PrimaryAccount primaryAcc = paService.getAccount(accno);
			return primaryAcc;
		}	
		else {
			System.out.println(accType);
			saService.deposit(accno ,amount);
			SavingsAccount savingsAcc = saService.getAccount(accno);
			return savingsAcc;
		}
			
    }
	
	@GetMapping("/withdraw/{accType}/{accno}/{amount}" )
    public Object withdraw(@PathVariable String accType, @PathVariable String accno, @PathVariable int amount) {
		//System.out.println(accNo);
		//System.out.println(accType.getClass());
		if(accType.equals("Primary")) {
			System.out.println(accType);
			String val = paService.withdraw(accno, amount);
			if(val.equals("Done")) {
			PrimaryAccount primaryAcc = paService.getAccount(accno);
			return primaryAcc;
			}
			else {
				return "Insufficient Balance";
			}
		}	
		else {
			System.out.println(accType);
			String val = saService.withdraw(accno, amount);
			if(val.equals("Done")) {
			SavingsAccount savingsAcc = saService.getAccount(accno);
			return savingsAcc;
			}
			else
			{
				return "Insufficient Balance";
			}
		}
		
			
    }
	
	@Autowired
    private TransactionService transactionService;
    
    @GetMapping("/accounts")
    public Iterable<PrimaryAccount> retrieveAllAccounts() {
        return primaryAccRepo.findAll();
    }

   
    @GetMapping("/accounts/{accno}/balance")
    public int retrieveAccountBalance(@PathVariable String accno) {
        PrimaryAccount pAccount = primaryAccRepo.findByAccno(accno);
        return pAccount.getBalance();
    }
    @GetMapping("/accounts/{accountId}/transactions")
    public List<Transactions> retrieveAccountTransactions(@PathVariable String accno) {
      
        return transactionService.retrieveTransactionsForAccount(accno);
    }
    
    /**
     * Finds the available balance and the list of transactions
     * for the given account
     * @param accountId - Unique bank account ID
     * @return Available balance and list of transactions for a given bank account
     */
    @GetMapping("/accounts/{accountId}/transactionDetails")
     public TransactionDetails retrieveAccountBalanceAndListOfTransactions(
            @PathVariable String accno) {
        PrimaryAccount account = primaryAccRepo.findByAccno(accno);
		/*
		 * if (!account.isPresent()) { throw new AccountNotFoundException(
		 * String.format("Account %s not found.", accountId)); }
		 */
        TransactionDetails transaction =
                new TransactionDetails(
                        account.getAccno(), 
                        account.getBalance(), 
                        transactionService.retrieveTransactionsForAccount(accno));
        return transaction;
    }
    @GetMapping("/primaryAccount/{id}")
    public Optional<PrimaryAccount> retrivePrimaryAccount(@PathVariable int id) {
		List<PrimaryAccount> accounts = primaryAccRepo.findAllByCurrentPrimaryUserId(id);
		if(accounts.size() > 0) {
			return Optional.of(accounts.get(0));
		} else {
			return Optional.empty();
		}
    }
    
    @GetMapping("/savingsAccount/{id}")
    public Optional<SavingsAccount> retriveSavingsAccount(@PathVariable int id) {
	    List<SavingsAccount> accounts = savingsAccRepo.findAllByCurrentSavingsUser(id);
		if(accounts.size() > 0) {
			return Optional.of(accounts.get(0));
		} else {
			return Optional.empty();
		}
    }
		
   
    @GetMapping("/getAllPrimaryAccounts")
    public List<PrimaryAccount> getAllPrimaryaccounts()
    {
    	return paService.getAllPrimaryAccounts();    
    }
	@GetMapping("/getAllSavingsAccount")
	public List<SavingsAccount> getAllSavingsAccounts(){
		return saService.getAllSavingsAccounts();
		
	}

}
	


