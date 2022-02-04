package com.revature.banking_application.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.revature.banking_application.generator.PasswordGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users{
	
	@Id
	@GenericGenerator(name = "userId_generator", strategy = "com.revature.banking_application.generator.UserIDGenerator")
	@GeneratedValue(generator = "userId_generator")
	@Column(name = "UserId")
	private Long userID;
	
	private String password;
	
	@OneToOne()
	@JoinColumn(name = "roleId", referencedColumnName = "id", updatable = false, insertable = false)
	@JsonIgnoreProperties("user")
	private UserRole userRole;
	
	Boolean verified;
	
	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private BankCustomers customer;
	
	@PrePersist
	public void initialPassword() {
		if(password == null) {
			password = PasswordGenerator.generateRandomPassword();
		}
		if(verified == null) {
			verified = false;
		}
	}
}
