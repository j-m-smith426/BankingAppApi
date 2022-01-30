package com.revature.banking_application.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserRole{
	@Id
	@Column(name = "id")
	private Long roleID;
	
	private String roleName;
	
	@OneToOne(mappedBy = "userRole")
	private Users user;
}
