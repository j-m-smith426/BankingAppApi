package com.revature.banking_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.banking_application.entities.UserRole;
@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {

}
