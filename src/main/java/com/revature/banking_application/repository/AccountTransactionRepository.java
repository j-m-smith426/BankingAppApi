package com.revature.banking_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.banking_application.entities.AccountTransaction;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

}
