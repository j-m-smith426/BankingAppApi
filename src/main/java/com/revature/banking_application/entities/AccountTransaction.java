package com.revature.banking_application.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	String referenceName;
	Date transaction_date;
	String transaction_type;
	String transaction_subtype;
	Double currentBalance;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	BankAccount associatedAccount;
	
//	public AccountTransaction (Long reference, String type, String subtype, Double currentBal ) {
//		
//	}
	
	
}
