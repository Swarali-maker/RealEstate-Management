package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Customer;
import com.spring.repository.CustomerRepository;

@Service
public class CustomerServices {
	@Autowired
    private CustomerRepository customerRepository;

    public void CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    public Optional<Customer> getByEmail(String email) {
        return customerRepository.findByCustomerEmail(email);
    }

    public Optional<Customer> getByName(String name) {
        return customerRepository.findByCustomerName(name);
    }

    public List<Customer> deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return getAllCustomers();
    }
}
