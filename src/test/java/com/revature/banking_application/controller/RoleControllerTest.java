package com.revature.banking_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RoleController.class)
public class RoleControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	public void addRole_callsServiceSaveRole() {
		
	}
	public void removeRole_callsServiceDeleteRole() {
		
	}
}
