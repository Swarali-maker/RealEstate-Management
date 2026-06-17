package com.spring.entity;
import java.time.LocalDateTime;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="leads")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Lead {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long leadId;
	
	@ManyToOne
	@JoinColumn(name="customer_id", nullable=false)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="region_id", nullable=false)
	private Region region;
	
	@Enumerated(EnumType.STRING)
	@Column(name="property_type", nullable=true)
	private PropertyType propertyType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="measurement_unit")
	private MeasurementUnit measurementUnit;
	
	@Column(name="unit_value")
	private double unitValue;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="property_id")
	private Property property;	
	
	@Column(name="budget", nullable=false)
	private double budget;
	
	@Enumerated(EnumType.STRING)
	@Column(name="source", nullable=false)
	private LeadSource source;
	
	@Column(name="remarks")
	private String remarks;
	
	@ManyToOne
	@JoinColumn(name="assigned_manager_id", nullable=false)
	private User manager;
	
	@ManyToOne
	@JoinColumn(name="assigned_agent_id")
	private User agent;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable=false)
	private LeadStatus status;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive = true;
	
	@Column(name="created_at", nullable=false)
	private LocalDateTime createdAt;
	
	@Column(name="updated_at")
	private LocalDateTime updatedAt;

	public long getLeadId() {
		return leadId;
	}

	public void setLeadId(long leadId) {
		this.leadId = leadId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public MeasurementUnit getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(MeasurementUnit measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public double getUnitValue() {
		return unitValue;
	}

	public void setUnitValue(double unitValue) {
		this.unitValue = unitValue;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public LeadSource getSource() {
		return source;
	}

	public void setSource(LeadSource source) {
		this.source = source;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public User getAgent() {
		return agent;
	}

	public void setAgent(User agent) {
		this.agent = agent;
	}

	public LeadStatus getStatus() {
		return status;
	}

	public void setStatus(LeadStatus status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Lead [leadId=" + leadId + ", customer=" + customer + ", region=" + region + ", propertyType="
				+ propertyType + ", measurementUnit=" + measurementUnit + ", unitValue=" + unitValue + ", project="
				+ project + ", property=" + property + ", budget=" + budget + ", source=" + source + ", remarks="
				+ remarks + ", manager=" + manager + ", agent=" + agent + ", status=" + status + ", isActive="
				+ isActive + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
