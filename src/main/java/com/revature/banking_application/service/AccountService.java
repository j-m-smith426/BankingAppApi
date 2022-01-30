package com.revature.banking_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.banking_application.entities.BankAccount;
import com.revature.banking_application.repository.BankAccountRepository;
@Service
public class AccountService {
	private BankAccountRepository accountRepository;

	public AccountService(BankAccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	public BankAccount getById(Long id) throws Exception {
		Optional<BankAccount> account = accountRepository.findById(id);
		if(account.isPresent()) {
			return account.get();
		}else {
			throw new Exception("Error creating Account");
		}
		
	}

	public BankAccount closeAccountById(Long i) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public BankAccount addAccount(BankAccount account) {
		BankAccount savedAccount = accountRepository.save(account);
		return savedAccount;
		
	}

	public List<BankAccount> findAllByCustomer(Long customerId) throws Exception {
		List<BankAccount> result = accountRepository.findByCustomerId(customerId);
		if(result != null) {
			return result;
		}else {
			throw new Exception("Error finding accounts for the customer");
		}
		
	}

	public BankAccount updateAccount(BankAccount account) {
		BankAccount savedAccount = accountRepository.save(account);
		return savedAccount;
	}

}
