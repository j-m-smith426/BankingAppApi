package com.revature.banking_application.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.banking_application.entities.Users;
import com.revature.banking_application.service.UserService;

@RestController
public class UserController {
	UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Users> login(@RequestBody Long username, @RequestBody String password) throws Exception{
		Users user = userService.verifyUser(username, password);
		if(user != null) {
			return new ResponseEntity<Users>(user, HttpStatus.OK);
		}else {
			throw new Exception("Credentials do not match");
		}
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<Users> updatePassword(@RequestBody Users user, @RequestBody String updatedPassword) throws Exception{
		Users result = userService.updatePassword(user, updatedPassword);
		if(result != null) {
			return new ResponseEntity<Users>(result, HttpStatus.OK);
		}else {
			throw new Exception("User not found");
		}
	}
	
	
}
