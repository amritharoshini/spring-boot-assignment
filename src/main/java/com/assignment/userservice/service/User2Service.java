package com.assignment.userservice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignment.userservice.model.User;
import com.assignment.userservice.model.User2;
import com.assignment.userservice.repository.User2Repository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class User2Service {
	
	private final User2Repository user2Repository;
	
	public boolean checkIfEmailExistsInUser2(String email) {
		Optional<User2> user2 = getUser2ByEmail(email);
		return user2.isPresent();
	}
	
	public Optional<User2> getUser2ByEmail(String email) {
		return this.user2Repository.findByEmail(email);
	}

}
