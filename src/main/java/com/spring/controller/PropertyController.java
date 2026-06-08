package com.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.AvailabilityStatus;
import com.spring.entity.Property;
import com.spring.entity.PropertyType;
import com.spring.services.PropertyServices;
@CrossOrigin
@RestController
@RequestMapping("/properties")
public class PropertyController {
	@Autowired
    private PropertyServices propertyService;

	@PostMapping
    public Property createProperty(@RequestBody Property property) {
        return propertyService.createProperty(property);
    }

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }

    @PutMapping("/{id}")
    public Property updateProperty(
            @PathVariable Long id,
            @RequestBody Property property) {

        return propertyService.updateProperty(id, property);
    }

    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
    }

    @GetMapping("/project/{projectId}")
    public List<Property> getPropertiesByProject(@PathVariable Long projectId) {
        return propertyService.getPropertiesByProject(projectId);
    }

    @GetMapping("/type/{type}")
    public List<Property> getPropertiesByType(@PathVariable PropertyType type) {
        return propertyService.getPropertiesByType(type);
    }

    @GetMapping("/status/{status}")
    public List<Property> getPropertiesByStatus(@PathVariable AvailabilityStatus status) {
        return propertyService.getPropertiesByStatus(status);
    }

    @GetMapping("/active")
    public List<Property> getActiveProperties() {
        return propertyService.getActiveProperties();
    }
}