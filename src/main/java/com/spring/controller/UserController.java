package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.User;
import com.spring.entity.UserRole;
import com.spring.services.UserServices;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    private UserServices userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public Optional<User> getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @GetMapping("/name/{name}")
    public Optional<User> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    @GetMapping("/role/{role}")
    public List<User> getByRole(@PathVariable UserRole role) {
        return userService.getByRole(role);
    }

    @GetMapping("/active")
    public List<User> getActiveUsers() {
        return userService.getActiveUsers();
    }

    @GetMapping("/active/role/{role}")
    public List<User> getActiveByRole(@PathVariable UserRole role) {
        return userService.getActiveUsersByRole(role);
    }

    @GetMapping("/region")
    public List<User> getByRegion(@RequestParam String regionName, @RequestParam UserRole role) {
        return userService.getUsersByRegion(regionName, role);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
