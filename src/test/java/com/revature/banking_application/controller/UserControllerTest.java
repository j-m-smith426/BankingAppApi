package com.revature.banking_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	public void login_callsServiceLoginUser() {
		
	}
	
	public void register_callsServiceRegisterUser() {
		
	}
	
	public void updateUser_callsServiceUpdateUser() {
		
	}

}
