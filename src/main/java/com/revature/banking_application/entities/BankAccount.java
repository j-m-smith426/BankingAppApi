package com.revature.banking_application.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
	
	
	Long accountID;
	Long customerID;
	
	Double currentBalance;
	
	@OneToMany(mappedBy = "associatedAccount")
	List<AccountTransaction> transactions;
}
