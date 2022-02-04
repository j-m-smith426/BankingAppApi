package com.revature.banking_application.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.banking_application.entities.AccountTransaction;
import com.revature.banking_application.entities.BankAccount;
import com.revature.banking_application.exception.InvalidTransaction;
import com.revature.banking_application.repository.AccountTransactionRepository;
@Service
public class TransactionService {
	
	private AccountTransactionRepository transactionRepository;
	private AccountService accountService;

	public TransactionService(AccountTransactionRepository transactionRepository, AccountService accountService) {
		this.transactionRepository = transactionRepository;
		this.accountService = accountService;
	}

	public AccountTransaction findById(Long id) throws Exception {
		Optional<AccountTransaction> transaction = transactionRepository.findById(id);
		if(transaction.isPresent()) {
			return transaction.get();
		}else{
			throw new Exception("Tansaction not found with id");
		}
	
	}

	public List<AccountTransaction> getAllAccountTransactions(Long account) {
		return transactionRepository.findAllByAccountId(account);
	}
	
	public List<AccountTransaction> getAllByAccountBetweenDates(Long account, Date begin, Date end){
		return transactionRepository.findAllByAccountIdBetweenDates(account, begin, end);
	}

	public AccountTransaction saveTransaction(AccountTransaction transaction) throws InvalidTransaction {
		try {
			BankAccount account = accountService.getById(transaction.getAssociatedAccount().getAccountID());
			account.setCurrentBalance(transaction.getCurrentBalance());
			transaction.setAssociatedAccount(account);
			
			return transactionRepository.save(transaction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidTransaction("Error saving transaction");
		}
	}

	public AccountTransaction updateTransaction(AccountTransaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountTransaction deleteTransaction(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
