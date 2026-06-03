package com.spring.entity;
import java.time.LocalDateTime;
import java.util.List;

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
	
	@Enumerated(EnumType.STRING)
	@Column(name="property_type", nullable=false)
	private PropertyType propertyType;
	
	@ManyToOne
	@JoinColumn(name="region_id")
	private Region region;
	
	@Column(name="address", nullable=false)
	private String address;
	
	@Enumerated(EnumType.STRING)
	private AvailabilityStatus status;
	
	@Column(name="is_active", nullable=false)
	private boolean isActive = true;
	
	@Column(name="created_at", nullable=false)
	private LocalDateTime createdAt;
	
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy="property")
	private List<Lead> leads;
}
