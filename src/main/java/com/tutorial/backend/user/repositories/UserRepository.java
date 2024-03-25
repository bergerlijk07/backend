package com.tutorial.backend.user.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tutorial.backend.user.model.User;
import com.tutorial.backend.user.model.UserDto;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT new com.tutorial.backend.user.model.UserDto(u.userId, u.firstName, u.lastName, u.emailId) "
			+ "FROM User u")
	List<UserDto> findAllUsers();

	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.isArchived = true WHERE u.userId = :userId")
	int archiveUser(Long userId);
	
	
	Optional<User> findByEmailId(String emailId);
}
