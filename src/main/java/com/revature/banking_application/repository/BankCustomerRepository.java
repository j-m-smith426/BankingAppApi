package com.revature.banking_application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.banking_application.entities.BankCustomers;
@Repository
public interface BankCustomerRepository extends JpaRepository<BankCustomers, Long> {
	@Query("SELECT customer from BankCustomers as customer where customer.user.userID = :customerId")
	Optional<BankCustomers> findByCustomerId(@Param(value = "customerId") Long customerId);

}
