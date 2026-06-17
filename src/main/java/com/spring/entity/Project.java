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
	@JsonIgnore
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

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public ProjectType getProjectType() {
		return projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	public ProjectStatus getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(int totalUnits) {
		this.totalUnits = totalUnits;
	}

	public LocalDate getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(LocalDate launchDate) {
		this.launchDate = launchDate;
	}

	public LocalDate getExpectedCompletionDate() {
		return expectedCompletionDate;
	}

	public void setExpectedCompletionDate(LocalDate expectedCompletionDate) {
		this.expectedCompletionDate = expectedCompletionDate;
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

	public List<Property> getProperty() {
		return property;
	}

	public void setProperty(List<Property> property) {
		this.property = property;
	}

	public List<Lead> getLead() {
		return lead;
	}

	public void setLead(List<Lead> lead) {
		this.lead = lead;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", developerName=" + developerName
				+ ", region=" + region + ", projectType=" + projectType + ", projectStatus=" + projectStatus
				+ ", address=" + address + ", description=" + description + ", totalUnits=" + totalUnits
				+ ", launchDate=" + launchDate + ", expectedCompletionDate=" + expectedCompletionDate + ", isActive="
				+ isActive + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", property=" + property
				+ ", lead=" + lead + "]";
	}
	
}
