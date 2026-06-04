package com.spring.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.*;
public interface PropertyRepository extends JpaRepository<Property, Long> {

    // Find by property name
    Optional<Property> findByPropertyName(String propertyName);

    // Check if property exists
    boolean existsByPropertyName(String propertyName);

    // Find by project
    List<Property> findByProject(Project project);

    // Find by project id
    List<Property> findByProjectProjectId(Long projectId);

    // Find by property type
    List<Property> findByPropertyType(PropertyType propertyType);

    // Find by region
    List<Property> findByRegion(Region region);

    // Find by region id
    List<Property> findByRegionRegionId(Long regionId);

    // Find by status
    List<Property> findByStatus(AvailabilityStatus status);

    // Find by measurement unit
    List<Property> findByMeasurementUnit(MeasurementUnit measurementUnit);

    // Find active properties
    List<Property> findByIsActiveTrue();

    // Find active/inactive properties
    List<Property> findByIsActive(boolean isActive);

    // Find active properties by project
    List<Property> findByProjectProjectIdAndIsActiveTrue(Long projectId);

    // Find active properties by region
    List<Property> findByRegionRegionIdAndIsActiveTrue(Long regionId);

    // Find active properties by type
    List<Property> findByPropertyTypeAndIsActiveTrue(PropertyType propertyType);

    // Find active properties by project and type
    List<Property> findByProjectProjectIdAndPropertyTypeAndIsActiveTrue(
            Long projectId,
            PropertyType propertyType);

    // Find available properties
    List<Property> findByStatusAndIsActiveTrue(
            AvailabilityStatus status);

    // Search by property name
    List<Property> findByPropertyNameContainingIgnoreCase(
            String propertyName);
}