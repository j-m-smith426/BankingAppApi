package com.revature.banking_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.banking_application.entities.BankAccount;
import com.revature.banking_application.entities.BankCustomers;
import com.revature.banking_application.exception.InvalidAccountException;
import com.revature.banking_application.repository.BankAccountRepository;
import com.revature.banking_application.repository.BankCustomerRepository;
@Service
public class AccountService {
	private BankAccountRepository accountRepository;
	private  BankCustomerService customerService;

	public AccountService(BankAccountRepository accountRepository,  BankCustomerService customerService) {
		super();
		this.accountRepository = accountRepository;
		this.customerService = customerService;
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

	public BankAccount addAccount(BankAccount account) throws InvalidAccountException {
		try {
		BankCustomers customer = customerService.findById(account.getCustomer().getCustomerUniqueID());
//		System.out.print(customer);
		account.setCustomer(customer);
		BankAccount savedAccount = accountRepository.save(account);
		return savedAccount;
		}catch(Exception e) {
			e.printStackTrace();
			throw new InvalidAccountException("Error creating account");
		}
		
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
