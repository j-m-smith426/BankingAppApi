package com.revature.banking_application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.banking_application.email.EmailServiceImpl;
import com.revature.banking_application.entities.BankCustomers;
import com.revature.banking_application.exception.InvalidCustomer;
import com.revature.banking_application.repository.BankCustomerRepository;
@Service
public class BankCustomerService {
	private BankCustomerRepository customerRepository;
	private EmailServiceImpl email;


	public BankCustomerService(BankCustomerRepository customerRepository, EmailServiceImpl email) {
		this.customerRepository = customerRepository;
		this.email = email;
	}

	public BankCustomers findByCustomerId(Long customerId) throws InvalidCustomer {
		Optional<BankCustomers> customer = customerRepository.findByCustomerId(customerId);
		if(!customer.isPresent()) {
			throw new InvalidCustomer("Customer not found");
		}else {
			return customer.get();
		}
	}

	public BankCustomers findById(Long personalId) {
		
		return customerRepository.findById(personalId).orElse(null);
	}

	public BankCustomers saveCustomer(BankCustomers customer) {
		try {
			System.out.println(customer);
		BankCustomers savedCustomer = customerRepository.save(customer);
//		email.sendMessage(savedCustomer);
		return savedCustomer;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public BankCustomers updateCustomer(BankCustomers customer) {
		// TODO Auto-generated method stub
		return null;
	}

	public BankCustomers deleteCustomer(Long personalId) {
		// TODO Auto-generated method stub
		return null;
	}

}
