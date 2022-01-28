package com.revature.banking_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.banking_application.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
