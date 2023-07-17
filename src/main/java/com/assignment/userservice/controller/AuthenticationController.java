package com.assignment.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.userservice.dto.AuthenticationRequest;
import com.assignment.userservice.dto.AuthenticationResponse;
import com.assignment.userservice.dto.RegisterRequest;
import com.assignment.userservice.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	
	private final AuthenticationService service;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterRequest request){
		Integer id = service.register(request);
		if(id == null) return ResponseEntity.badRequest().body("Registration Unsuccessful. Please try again later");
		return ResponseEntity.ok("Registration Success");
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(service.authenticate(request));
	}
	
}
