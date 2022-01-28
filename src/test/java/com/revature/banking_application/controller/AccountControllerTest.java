package com.revature.banking_application.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.banking_application.entities.BankAccount;
import com.revature.banking_application.service.AccountService;
import com.revature.banking_application.service.AccountServiceTest;

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
		Mockito.when(accountService.getByCustomerId(123456l)).thenReturn(new BankAccount());
		
		mockMvc.perform(
				MockMvcRequestBuilders.get("/account/customer/123456")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				
		verify(accountService, times(1)).getByCustomerId((long) 123456);
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
