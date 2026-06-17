package com.spring.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="users")

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="email", unique=true, nullable=false)
	private String email;
	
//	@Column(name="password", nullable=false)
//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//	private String password;
	
	@Column(name="password", nullable=false)
	@JsonIgnore
	private String password;
	
	@Column(name="phone", nullable=false)
	private long phone;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role", nullable=false)
	private UserRole role;
	
	// Region id
	@ManyToOne
	@JoinColumn(name="region_id")
	private Region region;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive = true;
	
	@Column(name="created_at", nullable=false)
	private LocalDateTime createdAt;
	
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "manager")
	@JsonIgnore
	private List<Lead> managedLeads;
	
	@JsonIgnore
	@OneToMany(mappedBy = "agent")
	private List<Lead> assignedLeads;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Lead> getManagedLeads() {
		return managedLeads;
	}

	public void setManagedLeads(List<Lead> managedLeads) {
		this.managedLeads = managedLeads;
	}

	public List<Lead> getAssignedLeads() {
		return assignedLeads;
	}

	public void setAssignedLeads(List<Lead> assignedLeads) {
		this.assignedLeads = assignedLeads;
	}

	@Override
	public String toString() {
	    return "User [userId=" + userId
	            + ", name=" + name
	            + ", email=" + email
	            + ", phone=" + phone
	            + ", role=" + role
	            + ", isActive=" + isActive
	            + "]";
	}
	
}
