package com.assignment.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.userservice.model.SecurityUser;

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser, Integer> {
	
	Optional<SecurityUser> findByUsername(String username);

}
