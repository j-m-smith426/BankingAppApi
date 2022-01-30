package com.revature.banking_application.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Users{
	
	@Id
	@Column(name = "UserId")
	private Long userID;
	
	private String password;
	
	@OneToOne()
	@JoinColumn(name = "roleId", referencedColumnName = "id")
	private UserRole userRole;
	
	Boolean verified;
	
	@OneToOne(mappedBy = "user")
	private BankCustomers customer;
}
