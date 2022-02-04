package com.revature.banking_application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.banking_application.entities.Users;
import com.revature.banking_application.exception.IllegalUserCredentials;
import com.revature.banking_application.repository.UserRepository;
@Service
public class UserService {
	
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public Users verifyUser(Long username, String password) throws IllegalUserCredentials {
		Optional<Users> user = userRepository.findById(username);
		if(user.get() != null) {
			Users retrievedUser = user.get();
			if(retrievedUser.getPassword().contentEquals(password)) {
				return retrievedUser;
			}else {
				throw new IllegalUserCredentials("Password dose not match");
			}
		}else {
			throw new IllegalUserCredentials("UserId not found");
		}
		
	}

	public Users updatePassword(Users user, String updatedPassword) {
		Optional<Users> optionalUser = userRepository.findById(user.getUserID());
		if(optionalUser.get() != null) {
			Users retrievedUser = optionalUser.get();
			retrievedUser.setPassword(updatedPassword);
			retrievedUser.setVerified(true);
			Users updatedUser = userRepository.save(retrievedUser);
			return updatedUser;
			
		}
		return null;
	}

	public Users saveUser(Users user) {
		
		return userRepository.save(user);
	}

}
