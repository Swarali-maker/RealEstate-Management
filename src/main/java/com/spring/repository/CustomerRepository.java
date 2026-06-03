package com.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	// Find by name
		Optional<Customer> findByCustomerName (String name);
		// Find by email
		Optional<Customer> findByCustomerEmail (String email);
		// Check if email already exists
	    boolean existsByCustomerEmail(String email);
		// Find by phone
		Optional<Customer> findByCustomerPhone (long phone);
		// Check if phone exists
		boolean existsByCustomerPhone(long phone);
}
