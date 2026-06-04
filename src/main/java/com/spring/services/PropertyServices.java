package com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.AvailabilityStatus;
import com.spring.entity.Property;
import com.spring.entity.PropertyType;
import com.spring.repository.PropertyRepository;

@Service
public class PropertyServices {
	@Autowired
    private PropertyRepository propertyRepository;


    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public Property updateProperty(Long id, Property property) {

        Property existing = getPropertyById(id);

        existing.setPropertyName(property.getPropertyName());
        existing.setProject(property.getProject());
        existing.setMeasurementUnit(property.getMeasurementUnit());
        existing.setUnitValue(property.getUnitValue());
        existing.setPropertyType(property.getPropertyType());
        existing.setRegion(property.getRegion());
        existing.setAddress(property.getAddress());
        existing.setStatus(property.getStatus());

        return propertyRepository.save(existing);
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    public List<Property> getPropertiesByProject(Long projectId) {
        return propertyRepository.findByProjectProjectId(projectId);
    }

    public List<Property> getPropertiesByType(PropertyType type) {
        return propertyRepository.findByPropertyType(type);
    }

    public List<Property> getPropertiesByStatus(AvailabilityStatus status) {
        return propertyRepository.findByStatus(status);
    }

    public List<Property> getActiveProperties() {
        return propertyRepository.findByIsActiveTrue();
    }
}
