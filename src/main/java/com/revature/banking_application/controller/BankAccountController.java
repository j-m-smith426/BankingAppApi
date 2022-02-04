package com.revature.banking_application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.banking_application.entities.BankAccount;
import com.revature.banking_application.service.AccountService;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class BankAccountController {

	private AccountService accountService;

	public BankAccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	//getAllByCustomerId
	
	@GetMapping("/{customerId}")
	public ResponseEntity<List<BankAccount>> retrieveCustomerAccounts(@PathVariable Long customerId){
		List<BankAccount> accounts;
		try {
			accounts = accountService.findAllByCustomer(customerId);
			return new ResponseEntity<List<BankAccount>>(accounts, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<BankAccount>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/single/{accountId}")
	public ResponseEntity<BankAccount> getSingleAccount(@PathVariable Long accountId){
		try {
			BankAccount account = accountService.getById(accountId);
			return new ResponseEntity<BankAccount>(account, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<BankAccount>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//add
	@PostMapping("/add")
	public ResponseEntity<BankAccount> addAccount(@RequestBody BankAccount account){
		try {
			BankAccount savedAccount = accountService.addAccount(account);
			return new ResponseEntity<BankAccount>(savedAccount, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<BankAccount>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//update
	@PutMapping("/update")
	public ResponseEntity<BankAccount> updateAccount(@RequestBody BankAccount account){
		try {
			BankAccount updatedAccount = accountService.updateAccount(account);
			return new ResponseEntity<BankAccount>(updatedAccount, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<BankAccount>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//delete
	@DeleteMapping("/delete/{accountId}")
	public ResponseEntity<BankAccount> deleteAccount(@PathVariable Long accountId){
		try {
			BankAccount account = accountService.closeAccountById(accountId);
			return new ResponseEntity<BankAccount>(account, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<BankAccount>(HttpStatus.BAD_REQUEST);
		}
	}
}
