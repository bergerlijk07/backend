package com.tutorial.backend.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.backend.user.repositories.UserRepository;

@Service
public class AuthenticationService {

	private UserRepository userRepository;
	
	@Autowired
	public AuthenticationService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
}
