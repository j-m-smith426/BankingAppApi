package com.revature.banking_application.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
//	@Column(name = "customerId")
//	Long customerId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "UserId")
	Users user;
	
	String name;
	Integer postal;
	String email;
	String dob;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	List<BankAccount> accounts;
	
	public void addAccount(BankAccount account) {
		accounts.add(account);
		account.setCustomer(this);
	}
	
	public void removeAccount(BankAccount account) {
		accounts.remove(account);
	}
}
