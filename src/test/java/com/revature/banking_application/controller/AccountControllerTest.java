package com.revature.banking_application.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.banking_application.entities.BankAccount;
import com.revature.banking_application.service.AccountService;

@WebMvcTest(BankAccountController.class)
public class AccountControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	private AccountService accountService;

	@Test
	public void getAllByCutomerId_callsServiceGetByCustomerId() throws Exception {
		List<BankAccount> accounts = new ArrayList<>();
		accounts.add(new BankAccount());
		Mockito.when(accountService.findAllByCustomer(123456l)).thenReturn(accounts);
		
		mockMvc.perform(
				MockMvcRequestBuilders.get("/account/customer/123456")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				
		verify(accountService, times(1)).findAllByCustomer((long) 123456);
	}
	
	public void addAccount_callsServiceAddAccount() throws Exception {
		BankAccount testAccount = new BankAccount();
		
		mockMvc.perform(
				MockMvcRequestBuilders.post("/account/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(testAccount))
				).andExpect(status().isOk());;
		verify(accountService, times(1)).addAccount(testAccount);
	}
	
	public void closeAccount_callsServiceCloseAccount() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.delete("/account/123456")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk());;
		verify(accountService, times(1)).closeAccountById(123456l);
	}
	
	public void getAccountByAccountId_callsServiceGetById() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/account/123456")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk());;
		verify(accountService, times(1)).getById(123456l);
	}
}
