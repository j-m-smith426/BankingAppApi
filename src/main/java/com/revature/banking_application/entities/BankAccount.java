package com.revature.banking_application.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
	
	@Id
	@GenericGenerator(name = "account_generator", strategy = "com.revature.banking_application.generator.AccountIdGenerator")
	@GeneratedValue(generator = "account_generator")
	Long accountID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customerId", nullable = false)
	BankCustomers customer;
	
	Double currentBalance;
	
	@OneToMany(mappedBy = "associatedAccount", cascade = CascadeType.ALL)
	@JsonIgnore
	List<AccountTransaction> transactions;
}
