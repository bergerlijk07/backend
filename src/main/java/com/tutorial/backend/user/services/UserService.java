package com.tutorial.backend.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tutorial.backend.user.model.User;
import com.tutorial.backend.user.model.UserDto;
import com.tutorial.backend.user.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private UserRepository userRepository;


	@Autowired
	public UserService(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	public UserDto addUpdateUser(UserDto userDto, Long userId) {

		User user = new User();
		if (userId != null) {
			user = userRepository.findById(userId).orElse(null);
		} else {
			user = new User(userDto);
			//String encodedPassword = userDto.getPassword() == null ? "" : passwordEncoder.encode(userDto.getPassword());
			user.setPassword(userDto.getPassword());
		}
		user = userRepository.save(user);
		
		return new UserDto(user);
	}
	
	public List<UserDto> getAllUsers() {
		
		return userRepository.findAllUsers();
				
	}
	
	public UserDto findUserById(Long userId) {
		
		User user = userRepository.findById(userId).orElse(null);
		
		if (user == null) {
			return new UserDto();
		}
		return new UserDto(user);
	}
	
	public boolean archiveUser(Long userId) {
		
		int rows = userRepository.archiveUser(userId);
		
		return rows > 0;
	}

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		
		return userRepository.findByEmailId(emailId).orElseThrow(() -> new UsernameNotFoundException("User with " + emailId + " was not found"));
	}
}
