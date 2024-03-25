package com.tutorial.backend.user.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.backend.common.Response;
import com.tutorial.backend.user.model.UserDto;
import com.tutorial.backend.user.services.UserService;
import com.tutorial.backend.util.CommonConstants;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
@Tag(name = "User")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<Response> addNewUser(HttpServletRequest request, UserDto userDto) {
		
		userDto = userService.addUpdateUser(userDto, null);
		
		Map<String, Object> data = new HashMap<>();
		data.put("user", userDto);
		
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), CommonConstants.SUCCESS_MSG, data), HttpStatus.OK);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<Response> addNewUser(HttpServletRequest request, @PathVariable Long userId, UserDto userDto) {
		
		userDto = userService.addUpdateUser(userDto, userId);
		
		Map<String, Object> data = new HashMap<>();
		data.put("user", userDto);
		
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), CommonConstants.SUCCESS_MSG, data), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Response> getAllUsers(HttpServletRequest request) {
		
		List<UserDto> users = userService.getAllUsers();
		
		Map<String, Object> data = new HashMap<>();
		data.put("users", users);
		
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), CommonConstants.SUCCESS_MSG, data), HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Response> getUserById(HttpServletRequest request, @PathVariable Long userId) {
		
		UserDto userDto = userService.findUserById(userId);
		
		Map<String, Object> data = new HashMap<>();
		data.put("users", userDto);
		
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), CommonConstants.SUCCESS_MSG, data), HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Response> archiveUser(HttpServletRequest request, @PathVariable Long userId) {
		
		String statusMsg = userService.archiveUser(userId) ? CommonConstants.SUCCESS_MSG : CommonConstants.ERROR_MSG;
		
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), statusMsg), HttpStatus.OK);
	}
}
