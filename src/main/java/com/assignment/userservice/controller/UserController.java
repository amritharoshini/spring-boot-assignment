package com.assignment.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.userservice.dto.UserDto;
import com.assignment.userservice.service.User2Service;
import com.assignment.userservice.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	private final User2Service user2Service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createUsers(){
		this.userService.createUsers();
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<?> getUserByEmail(@PathVariable("email") String email) {
		if(!user2Service.checkIfEmailExistsInUser2(email))
			return ResponseEntity.badRequest().body("User does not exist in TABLE B");
		UserDto user = userService.getUserByEmail(email);
		return ResponseEntity.ok(user);
	}
}
