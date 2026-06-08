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
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Lead;
import com.spring.entity.LeadStatus;
import com.spring.services.LeadServices;
@CrossOrigin
@RestController
@RequestMapping("/leads")
public class LeadController {
	@Autowired
    private LeadServices leadService;

	@PostMapping
    public Lead createLead(@RequestBody Lead lead) {
		System.out.println("Lead received = " + lead);
	    System.out.println("Customer = " + lead.getCustomer());
	    System.out.println("Region = " + lead.getRegion());
        return leadService.createLead(lead);
    }

    @GetMapping
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }

    @GetMapping("/{id}")
    public Lead getLeadById(@PathVariable Long id) {
        return leadService.getLeadById(id);
    }

    @PutMapping("/{id}")
    public Lead updateLead(
            @PathVariable Long id,
            @RequestBody Lead lead) {

        return leadService.updateLead(id, lead);
    }
    
    @PutMapping("/{leadId}/assign-to/{agentId}")
    public Lead assignAgent(
            @PathVariable Long leadId,
            @PathVariable Long agentId) {

        return leadService.assignAgent(leadId, agentId);
    }

    @DeleteMapping("/{id}")
    public void deleteLead(@PathVariable Long id) {
        leadService.deleteLead(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Lead> getLeadsByCustomer(@PathVariable Long customerId) {
        return leadService.getLeadsByCustomer(customerId);
    }

    @GetMapping("/manager/{managerId}")
    public List<Lead> getLeadsByManager(@PathVariable Long managerId) {
        return leadService.getLeadsByManager(managerId);
    }

    @GetMapping("/agent/{agentId}")
    public List<Lead> getLeadsByAgent(@PathVariable Long agentId) {
        return leadService.getLeadsByAgent(agentId);
    }

    @GetMapping("/status/{status}")
    public List<Lead> getLeadsByStatus(@PathVariable LeadStatus status) {
        return leadService.getLeadsByStatus(status);
    }

    @GetMapping("/active")
    public List<Lead> getActiveLeads() {
        return leadService.getActiveLeads();
    }
    
    @GetMapping("/region/{regionId}")
    public List<Lead> getLeadsByRegion(@PathVariable Long regionId){
    	return leadService.getLeadsByRegion(regionId);
    }
    
    @GetMapping("/region/{regionId}/assigned")
    public List<Lead> getAssignedLeadsByRegion(
            @PathVariable Long regionId) {

        return leadService.getAssignedLeadsByRegion(regionId);
    }

    @GetMapping("/region/{regionId}/unassigned")
    public List<Lead> getUnassignedLeadsByRegion(
            @PathVariable Long regionId) {

        return leadService.getUnassignedLeadsByRegion(regionId);
    }
    
    @GetMapping("/assigned")
    public List<Lead> getAllAssignedLeads() {
    	return leadService.getAssignedLeads();
    }
    
    @GetMapping("/unassigned")
    public List<Lead> getAllUnassignedLeads() {
    	return leadService.getUnassignedLeads();
    }
}
