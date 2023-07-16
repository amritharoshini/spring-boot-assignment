package com.assignment.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.userservice.model.User2;

@Repository
public interface User2Repository extends JpaRepository<User2, Long> {

	Optional<User2> findByEmail(String email);

}
