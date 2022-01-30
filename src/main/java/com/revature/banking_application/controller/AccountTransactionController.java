package com.revature.banking_application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.banking_application.entities.AccountTransaction;
import com.revature.banking_application.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class AccountTransactionController {
	
	private TransactionService transactionService;

	public AccountTransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	//get by id
	@GetMapping("/{id}")
	public ResponseEntity<AccountTransaction> getTransactionById(@PathVariable Long id ){
		try {
			AccountTransaction transaction = transactionService.findById(id);
			return new ResponseEntity<AccountTransaction>(transaction,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<AccountTransaction>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//get all by account
	@GetMapping("/account/{account}")
	public ResponseEntity<List<AccountTransaction>> getTransactionsByAccount(@PathVariable Long account){
		try {
			List<AccountTransaction> transactions = transactionService.getAllAccountTransactions(account);
			return new ResponseEntity<List<AccountTransaction>>(transactions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<AccountTransaction>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//add transaction
	@PostMapping("/")
	public ResponseEntity<AccountTransaction> addTransaction(@RequestBody AccountTransaction transaction){
		try {
			AccountTransaction savedTransaction = transactionService.saveTransaction(transaction);
			return new ResponseEntity<AccountTransaction>(savedTransaction, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<AccountTransaction>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//update transaction
	@PutMapping("/")
	public ResponseEntity<AccountTransaction> updateTransaction(@RequestBody AccountTransaction transaction){
		try {
			AccountTransaction savedTransaction = transactionService.updateTransaction(transaction);
			return new ResponseEntity<AccountTransaction>(savedTransaction, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<AccountTransaction>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//delete transaction by transaction id
	@DeleteMapping("/{id}")
	public ResponseEntity<AccountTransaction> deleteTransaction(@PathVariable Long id){
		try {
			AccountTransaction deletedTransaction = transactionService.deleteTransaction(id);
			return new ResponseEntity<AccountTransaction>(deletedTransaction, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<AccountTransaction>(HttpStatus.BAD_REQUEST);
		}
	}

}
