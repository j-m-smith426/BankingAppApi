package com.revature.banking_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.banking_application.entities.AccountTransaction;
import com.revature.banking_application.repository.AccountTransactionRepository;
@Service
public class TransactionService {
	
	private AccountTransactionRepository transactionRepository;

	public TransactionService(AccountTransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
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
		// TODO Auto-generated method stub
		return null;
	}

	public AccountTransaction saveTransaction(AccountTransaction transaction) {
		// TODO Auto-generated method stub
		return null;
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
