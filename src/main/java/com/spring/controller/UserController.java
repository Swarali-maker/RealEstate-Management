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

import com.spring.entity.Region;
import com.spring.entity.User;
import com.spring.entity.UserRole;
import com.spring.services.RegionServices;
import com.spring.services.UserServices;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    private UserServices userService;
	
	@Autowired
	private RegionServices regionService;

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
    
    @GetMapping("/managers")
    public List<User> getManagers(){
    	return userService.getManagers();
    }
    
    @GetMapping("/agents")
    public List<User> getAgents(){
    	return userService.getAgents();
    }
    
    @GetMapping("/admin")
    public List<User> getAdmins(){
    	return userService.getAdmins();
    }
    
    @GetMapping("/managers/region/{regionId}")
    public Optional<User> getManagersByRegion(@PathVariable Long regionId) {

        Region region = regionService.getById(regionId)
                .orElseThrow(() -> new RuntimeException("Region not found"));

        return userService.getManagerByRegion(region);
    }
    
    @GetMapping("/agents/region/{regionId}")
    public Optional<User> getAgentsByRegion(@PathVariable Long regionId){
    	Region region = regionService.getById(regionId)
                .orElseThrow(() -> new RuntimeException("Region not found"));

        return userService.getAgentsByRegion(region);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
