package com.revature.banking_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.banking_application.entities.AccountTransaction;
@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

}
