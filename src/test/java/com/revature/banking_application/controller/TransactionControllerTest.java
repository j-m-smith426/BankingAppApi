package com.revature.banking_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AccountTransactionController.class)
public class TransactionControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;

	public void addTransaction_callsServiceSave() {
		
	}
	
	public void deleteTransaction_callsServiceDelete() {
		
	}
	
}
