package com.revature.banking_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.banking_application.entities.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	
}
