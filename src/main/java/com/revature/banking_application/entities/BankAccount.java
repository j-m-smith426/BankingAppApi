package com.revature.banking_application.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
	
	@Id
	Long accountID;
	Long customerId;
	
	Double currentBalance;
	
	@OneToMany(mappedBy = "associatedAccount")
	List<AccountTransaction> transactions;
}
