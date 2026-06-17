package com.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.entity.Region;
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
	long countByRole(UserRole role);
	
	List<User> findByRegionRegionNameAndRole(String regionName,UserRole role);
	@Query("""
		       SELECT u
		       FROM User u
		       WHERE u.region = :region
		         AND u.role = :role
		       """)
		User findByRegionAndRole(
		        @Param("region") Region region,
		        @Param("role") UserRole role
		);
	// Find all active users
	List<User> findByIsActiveTrue();
	// Find all active users by role
	List<User> findByRoleAndIsActiveTrue(UserRole role);
	// Find by role and region
	Optional<User> findByRoleAndRegion(UserRole role,Region region);
	
}
