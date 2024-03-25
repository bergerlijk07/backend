package com.tutorial.backend.user.model;

public class UserDto {

	private Long userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private Boolean isArchived = false;
	
	public UserDto() {
		//Empty Constructor
	}
	
	public UserDto(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.emailId = user.getEmailId();
		this.isArchived = user.getIsArchived();
	}
	
	public UserDto(Long userId, String firstName, String lastName, String emailId, String password, Boolean isArchived) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.isArchived = isArchived;
	}
	
	public UserDto(Long userId, String firstName, String lastName, String emailId, Boolean isArchived) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.isArchived = isArchived;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsArchived() {
		return isArchived;
	}

	public void setIsArchived(Boolean isArchived) {
		this.isArchived = isArchived;
	}
}
