package com.spring.entity;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="regions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Region {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long regionId;
	
	@Column(name="region_name", nullable=false, unique=true)
	private String regionName;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive = true;
	
	@Column(name="created_at", nullable=false)
	private LocalDateTime createdAt;
	
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy="region")
	@JsonIgnore
	private List<User> users;
	
	@OneToMany(mappedBy="region")
	@JsonIgnore
	private List<Property> properties;
	
	@OneToMany(mappedBy="region")
	@JsonIgnore
	private List<Lead> leads;
	
	@OneToMany(mappedBy="region")
	@JsonIgnore
	private List<Project> projects;
}
