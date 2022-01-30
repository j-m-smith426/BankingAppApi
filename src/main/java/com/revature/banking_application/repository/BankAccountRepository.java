package com.revature.banking_application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.banking_application.entities.BankAccount;
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

	List<BankAccount> findByCustomerId(Long customerId);

}
