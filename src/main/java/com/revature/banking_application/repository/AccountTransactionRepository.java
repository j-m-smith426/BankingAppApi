package com.revature.banking_application.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.banking_application.entities.AccountTransaction;
@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

	@Query("Select transaction from AccountTransaction as transaction where transaction.associatedAccount.accountID = :account")
	List<AccountTransaction> findAllByAccountId(@Param("account") Long account);
	
	@Query("Select transaction from AccountTransaction as transaction where transaction.associatedAccount.accountID = :account AND transaction.transaction_date BETWEEN	:begin AND :end")
	List<AccountTransaction> findAllByAccountIdBetweenDates(@Param("account") Long account,@Param("begin") Date begin,@Param("end") Date end);

}
