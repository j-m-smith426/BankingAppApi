package com.revature.banking_application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.banking_application.entities.BankAccount;
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
	
	@Query("Select account from BankAccount as account where account.customer.user.userID = :customerId")
	List<BankAccount> findByCustomerId(@Param("customerId") Long customerId);

}
