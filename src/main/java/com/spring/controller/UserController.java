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
import org.springframework.web.bind.annotation.PutMapping;

import com.spring.entity.Region;
import com.spring.entity.User;
import com.spring.entity.UserRole;
import java.util.HashMap;
import java.util.Map;
import com.spring.repository.LeadRepository;

import com.spring.repository.ProjectRepository;
import com.spring.repository.PropertyRepository;
import com.spring.repository.RegionRepository;
import com.spring.repository.UserRepository;
import com.spring.services.RegionServices;
import com.spring.services.UserServices;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LeadRepository leadRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private PropertyRepository propertyRepository;

	@Autowired
	private RegionRepository regionRepository;
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
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody User user) {
        return userService.updateUser(id, user);
    }
    @GetMapping("/test")
    public String test() {
        return "API Working";
    }
    @GetMapping("/dashboard")
	public Map<String, Object> getDashboard() {

	    Map<String, Object> data = new HashMap<>();

	    data.put("totalUsers", userRepository.count());

	    data.put("totalManagers",
	            userRepository.countByRole(UserRole.MANAGER));

	    data.put("totalAgents",
	            userRepository.countByRole(UserRole.AGENT));

	    data.put("totalLeads",
	            leadRepository.count());

	    data.put("totalProjects",
	            projectRepository.count());

	    data.put("totalProperties",
	            propertyRepository.count());

	    data.put("totalRegions",
	            regionRepository.count());

	    return data;
	}
}
