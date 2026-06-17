 package com.spring.entity;
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
@Table(name="properties")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Property {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long propertyId;
	
	@Column(name="property_name", nullable=false)
	private String propertyName;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="project_id", nullable=false)
	private Project project;
	
	@Enumerated(EnumType.STRING)
	@Column(name="measurement_unit")
	private MeasurementUnit measurementUnit;
	
	@Column(name="unit_value")
	private double unitValue;
	
	@Enumerated(EnumType.STRING)
	@Column(name="property_type", nullable=false)
	private PropertyType propertyType;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="region_id")
	private Region region;
	
	@Column(name="address", nullable=false)
	private String address;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable=false)
	private AvailabilityStatus status;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive = true;
	
	@Column(name="created_at", nullable=false)
	private LocalDateTime createdAt;
	
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy="property")
	@JsonIgnore
	private List<Lead> leads;

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AvailabilityStatus getStatus() {
		return status;
	}

	public void setStatus(AvailabilityStatus status) {
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

	public List<Lead> getLeads() {
		return leads;
	}

	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", propertyName=" + propertyName + ", project=" + project
				+ ", measurementUnit=" + measurementUnit + ", unitValue=" + unitValue + ", propertyType=" + propertyType
				+ ", region=" + region + ", address=" + address + ", status=" + status + ", isActive=" + isActive
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", leads=" + leads + "]";
	}
	
}
