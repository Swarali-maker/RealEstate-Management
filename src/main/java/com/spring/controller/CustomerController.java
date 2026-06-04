package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Customer;
import com.spring.services.CustomerServices;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
    private CustomerServices customerService;

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @GetMapping("/email/{email}")
    public Optional<Customer> getByEmail(@PathVariable String email) {
        return customerService.getByEmail(email);
    }

    @GetMapping("/name/{name}")
    public Optional<Customer> getByName(@PathVariable String name) {
        return customerService.getByName(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}