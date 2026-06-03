package com.spring.entity;
import java.time.LocalDateTime;

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
@Data
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
	@Column(name="property_type", nullable=false)
	private PropertyType propertyType;
	
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
}
