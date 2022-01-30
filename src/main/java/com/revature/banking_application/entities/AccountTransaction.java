package com.revature.banking_application.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountTransaction {
	@Id
	@Column(name = "transactionID")
	@GenericGenerator(name = "transaction_id", strategy = "com.revature.banking_application.generator.TransactionIdGenerator")
	@GeneratedValue(generator = "transaction_id")
	Long transactionID;
	Long referenceNumber;
	Date transaction_date;
	String transaction_type;
	String transaction_subtype;
	Double currentBalance;
	
	@ManyToOne()
	@JoinColumn(name = "account_id", nullable = false)
	BankAccount associatedAccount;
	
//	public AccountTransaction (Long reference, String type, String subtype, Double currentBal ) {
//		
//	}
	
	
}
