package com.assignment.userservice.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.assignment.userservice.dto.AuthenticationRequest;
import com.assignment.userservice.dto.AuthenticationResponse;
import com.assignment.userservice.dto.RegisterRequest;
import com.assignment.userservice.model.Role;
import com.assignment.userservice.model.SecurityUser;
import com.assignment.userservice.repository.SecurityUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final PasswordEncoder passwordEncoder;
	
	private final SecurityUserRepository repository;
	
	private final JwtService jwtService;
	
	private final AuthenticationManager authenticationManager;
	
	public Integer register(RegisterRequest request) {
		var user = SecurityUser
				.builder()
				.username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER)
				.build();
		return repository.save(user).getId();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
		);
		var user = repository.findByUsername(request.getUsername())
				.orElseThrow();
		
		String jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse
				.builder()
				.token(jwtToken)
				.build();
	}

}
