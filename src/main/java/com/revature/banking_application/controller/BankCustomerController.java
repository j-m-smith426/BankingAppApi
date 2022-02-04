package com.revature.banking_application.controller;

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

import com.revature.banking_application.entities.BankCustomers;
import com.revature.banking_application.exception.InvalidCustomer;
import com.revature.banking_application.service.BankCustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class BankCustomerController {
	private BankCustomerService customerService;
	
	
	public BankCustomerController(BankCustomerService customerService) {
		this.customerService = customerService;
	}

	//get
	@GetMapping("/{customerId}")
	public ResponseEntity<BankCustomers> getCustomerByID(@PathVariable Long customerId) throws Exception {
		BankCustomers customer = customerService.findByCustomerId(customerId);
		if(customer != null) {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}else {
			throw new InvalidCustomer("Customer dose not exist");
		}
	}
	
	@GetMapping("/personal/{personalId}")
	public ResponseEntity<BankCustomers> getCustomerByPersonalId(@PathVariable Long personalId) throws Exception{
		BankCustomers customer = customerService.findById(personalId);
		if(customer != null) {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}else {
			throw new Exception("Customer dose not exist");
		}
	}
	//add
	@PostMapping("/add")
	public ResponseEntity<BankCustomers> addNewCustomer(@RequestBody BankCustomers customer) throws Exception{
		
		BankCustomers savedCustomer = customerService.saveCustomer(customer);
		
			return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
	}
	
	//update
	@PutMapping("/update")
	public ResponseEntity<BankCustomers> updateCustomer(@RequestBody BankCustomers customer) throws Exception{
		BankCustomers savedCustomer = customerService.updateCustomer(customer);
			return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
		
	}
	
	//delete
	@DeleteMapping("/delete/{personalId}")
	public ResponseEntity<BankCustomers> deleteCustomer(@PathVariable Long personalId) throws Exception{
		BankCustomers deletedCustomer = customerService.deleteCustomer(personalId);
		if(deletedCustomer != null) {
			return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
		}else {
			throw new Exception("Error deleting Customer");
		}
	}

}
