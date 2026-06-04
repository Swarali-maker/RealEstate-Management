package com.spring.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long projectId;
	
	@Column(name="project_name", nullable=false)
	private String projectName;
	
	@Column(name="developer_name")
	private String developerName;
	
	@ManyToOne
	@JoinColumn(name="region_id", nullable=false)
	private Region region;
	
	@Enumerated(EnumType.STRING)
	@Column(name="project_type", nullable=false)
	private ProjectType projectType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="project_status", nullable=false)
	private ProjectStatus projectStatus;
	
	@Column(name="address", nullable=false)
	private String address;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="total_units")
	private int totalUnits;
	
	@Column(name="launch_date")
	private LocalDate launchDate;
	
	@Column(name="expected_completion_date")
	private LocalDate expectedCompletionDate;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive = true;
	
	@Column(name="created_at", nullable=false)
	private LocalDateTime createdAt;
	
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy="project")
	@JsonIgnore
	private List<Property> property;
	
	@OneToMany(mappedBy="project")
	@JsonIgnore
	private List<Lead> lead;
}
