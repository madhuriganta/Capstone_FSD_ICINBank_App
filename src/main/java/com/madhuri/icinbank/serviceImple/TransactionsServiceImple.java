package com.madhuri.icinbank.serviceImple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhuri.icinbank.Exceptions.InvalidAccountException;
import com.madhuri.icinbank.dao.PrimaryAccountRepository;

import com.madhuri.icinbank.dao.TransactionsRepository;
import com.madhuri.icinbank.model.PrimaryAccount;

import com.madhuri.icinbank.model.Transactions;
import com.madhuri.icinbank.service.TransactionService;

@Service
public class TransactionsServiceImple  implements TransactionService{

	@Autowired
    private TransactionsRepository transactionRepo;
    
    @Autowired
    private PrimaryAccountRepository primaryAccountRepo;
    

	@Override
	public void transferMoney(Transactions transaction) {
		// TODO Auto-generated method stub
		PrimaryAccount rAccount = 
				primaryAccountRepo.findByAccno(transaction.getRaccount());
	        System.out.println("rACC"+rAccount);
	        PrimaryAccount sAccount = 
				primaryAccountRepo.findByAccno(transaction.getSaccount());
	System.out.println("sAcc"+sAccount);
       
        if (sAccount==null || rAccount==null) {
            throw new InvalidAccountException(
                    "Invalid source account " + "or destination account ");
        }

//        transaction.runValidationTests(
//        		sAccount, rAccount);

        int transactionAmount = 
                transaction.getAmount();
        sAccount.setBalance(
        		sAccount.getBalance() - transactionAmount); // subtraction logic
        rAccount.setBalance(
        		rAccount.getBalance() + transactionAmount); // addition logic

        transactionRepo.save(transaction);

        primaryAccountRepo.save(sAccount);
        primaryAccountRepo.save(rAccount);
		
	}

	@Override
	public String retreiveAccountNumber(int id) {
		Optional<PrimaryAccount> account =  primaryAccountRepo.findById(id);
		String accNo = account.get().getAccno();
		return accNo;
	}

	@Override
	public List<Transactions> retrieveTransactionsForAccount(String accno) {
		// TODO Auto-generated method stub
		return transactionRepo.retrieveTransactionsForAccount(accno);
	}
//	@Override
//	public List<Transactions> getAllTransactions(String accountNo) {
//		List<Transactions> sender=transactionRepo.findBySaccount(accountNo);
//		List<Transactions> receiver=transactionRepo.findByRaccount(accountNo);
//		List<Transactions> merged=new ArrayList<>();
//		merged.addAll(sender);
//		merged.addAll(receiver);
//		Collections.sort((List<T>) merged);
//		return merged;
//	}

	@Override
	public Transactions addAction(String saccount, String raccount, int amount) {
		// TODO Auto-generated method stub
		return null;
	}


}
