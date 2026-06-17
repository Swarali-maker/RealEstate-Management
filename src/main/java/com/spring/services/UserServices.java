package com.spring.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Region;
import com.spring.entity.User;
import com.spring.entity.UserRole;
import com.spring.repository.RegionRepository;
import com.spring.repository.UserRepository;

@Service
public class UserServices {
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private RegionRepository regionRepository;

    public User saveUser(User user) {

        System.out.println("========== USER DATA ==========");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Phone: " + user.getPhone());
        System.out.println("Role: " + user.getRole());
        System.out.println("Region: " + user.getRegion());
        System.out.println("===============================");

        resolveRegion(user);

        if(user.getRole() == UserRole.MANAGER) {

            Optional<User> existingManager =
                    userRepository.findByRoleAndRegion(
                            UserRole.MANAGER,
                            user.getRegion()
                    );

            if(existingManager.isPresent()) {
                throw new RuntimeException(
                        "This region already has a manager assigned."
                );
            }
        }

        user.setCreatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        resolveRegion(user);

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        if (user.getPassword() != null && !user.getPassword().isBlank()) {
            existing.setPassword(user.getPassword());
        }
        existing.setPhone(user.getPhone());
        existing.setRole(user.getRole());
        existing.setRegion(user.getRegion());
        existing.setActive(user.isActive());
        existing.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(existing);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getByRole(UserRole role) {
        return userRepository.findByRole(role);
    }

    public List<User> getActiveUsers() {
        return userRepository.findByIsActiveTrue();
    }

    public List<User> getActiveUsersByRole(UserRole role) {
        return userRepository.findByRoleAndIsActiveTrue(role);
    }

    public List<User> getUsersByRegion(String regionName, UserRole role) {
        return userRepository.findByRegionRegionNameAndRole(regionName, role);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public List<User> getManagers(){
    	return userRepository.findByRole(UserRole.MANAGER);
    }
    
    public List<User> getAgents(){
    	return userRepository.findByRole(UserRole.AGENT);
    }
    
    public Optional<User> getManagerByRegion(Region region){
        return userRepository.findByRoleAndRegion(UserRole.MANAGER, region);
    }
    
    public Optional<User> getAgentsByRegion(Region region){
    	return userRepository.findByRoleAndRegion(UserRole.AGENT, region);
    }
    
    public List<User> getAdmins(){
    	return userRepository.findByRole(UserRole.ADMIN);
    }

    private void resolveRegion(User user) {
        if (user.getRegion() != null && user.getRegion().getRegionId() != 0) {
            user.setRegion(regionRepository.findById(user.getRegion().getRegionId())
                    .orElseThrow(() -> new RuntimeException("Region not found")));
        }
    }
    
}
