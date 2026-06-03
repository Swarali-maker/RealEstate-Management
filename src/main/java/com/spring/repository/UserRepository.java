package com.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.User;
import com.spring.entity.UserRole;

public interface UserRepository extends JpaRepository<User, Long>{
	// Find by name
	Optional<User> findByName (String name);
	// Find by email
	Optional<User> findByEmail (String email);
	// Check if email already exists
    boolean existsByEmail(String email);
	// Find by phone
	Optional<User> findByPhone (long phone);
	// Check if phone exists
	boolean existsByPhone(long phone);
	// Find by Role
	List<User> findByRole (UserRole role);
	// Find user by region name
	List<User> findByRegionRegionNameAndRole(String regionName,UserRole role);
	// Find all active users
	List<User> findByIsActiveTrue();
	// Find all active users by role
	List<User> findByRoleAndIsActiveTrue(UserRole role);
}
