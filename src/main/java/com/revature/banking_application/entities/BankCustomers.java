package com.revature.banking_application.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankCustomers {
	@Id
	Long customerUniqueID;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "UserId")
	Users user;
	
	String name;
	Integer postal;
	String email;
	String dob;
}
