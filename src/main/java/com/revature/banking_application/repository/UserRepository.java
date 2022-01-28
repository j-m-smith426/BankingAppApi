package com.revature.banking_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.banking_application.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	
}
