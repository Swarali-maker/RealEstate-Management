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
@Data
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
}
