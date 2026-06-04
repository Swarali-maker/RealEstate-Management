package com.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Customer;
import com.spring.entity.Lead;
import com.spring.entity.LeadSource;
import com.spring.entity.LeadStatus;
import com.spring.entity.MeasurementUnit;
import com.spring.entity.Project;
import com.spring.entity.Property;
import com.spring.entity.PropertyType;
import com.spring.entity.Region;
import com.spring.entity.User;
public interface LeadRepository extends JpaRepository<Lead, Long> {

    // Find by customer
    List<Lead> findByCustomer(Customer customer);

    // Find by customer id
    List<Lead> findByCustomerCustomerId(Long customerId);

    // Find by region
    List<Lead> findByRegion(Region region);

    // Find by region id
    List<Lead> findByRegionRegionId(Long regionId);

    // Find by property type
    List<Lead> findByPropertyType(PropertyType propertyType);

    // Find by measurement unit
    List<Lead> findByMeasurementUnit(MeasurementUnit measurementUnit);

    // Find by project
    List<Lead> findByProject(Project project);

    // Find by project id
    List<Lead> findByProjectProjectId(Long projectId);

    // Find by property
    List<Lead> findByProperty(Property property);

    // Find by property id
    List<Lead> findByPropertyPropertyId(Long propertyId);

    // Find by source
    List<Lead> findBySource(LeadSource source);

    // Find by manager
    List<Lead> findByManager(User manager);

    // Find by manager id
    List<Lead> findByManagerUserId(Long managerId);

    // Find by agent
    List<Lead> findByAgent(User agent);

    // Find by agent id
    List<Lead> findByAgentUserId(Long agentId);

    // Find by status
    List<Lead> findByStatus(LeadStatus status);

    // Find active leads
    List<Lead> findByIsActiveTrue();

    // Find active/inactive leads
    List<Lead> findByIsActive(boolean isActive);

    // Find leads by manager and status
    List<Lead> findByManagerAndStatus(
            User manager,
            LeadStatus status);

    // Find leads by agent and status
    List<Lead> findByAgentAndStatus(
            User agent,
            LeadStatus status);

    // Find active leads by manager
    List<Lead> findByManagerUserIdAndIsActiveTrue(Long managerId);

    // Find active leads by agent
    List<Lead> findByAgentUserIdAndIsActiveTrue(Long agentId);

    // Find active leads by project
    List<Lead> findByProjectProjectIdAndIsActiveTrue(Long projectId);

    // Find active leads by property
    List<Lead> findByPropertyPropertyIdAndIsActiveTrue(Long propertyId);
}