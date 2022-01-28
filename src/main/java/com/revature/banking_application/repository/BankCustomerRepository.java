package com.revature.banking_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.banking_application.entities.BankCustomers;

public interface BankCustomerRepository extends JpaRepository<BankCustomers, Long> {

}
