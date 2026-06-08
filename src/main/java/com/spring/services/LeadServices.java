package com.spring.services;
import com.spring.entity.*;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Customer;
import com.spring.entity.Lead;
import com.spring.entity.LeadStatus;
import com.spring.entity.Region;
import com.spring.entity.User;
import com.spring.entity.UserRole;
import com.spring.repository.CustomerRepository;
import com.spring.repository.LeadRepository;
import com.spring.repository.RegionRepository;
import com.spring.repository.UserRepository;

@Service
public class LeadServices {
	@Autowired
    private LeadRepository leadRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private RegionRepository regionRepository;


	public Lead createLead(Lead lead) {
		lead.setCreatedAt(LocalDateTime.now());
		Customer customer = customerRepository
			    .findByCustomerPhone(lead.getCustomer().getCustomerPhone())
			    .orElseGet(() -> {
			        Customer c = new Customer();
			        c.setCustomerName(lead.getCustomer().getCustomerName());
			        c.setCustomerPhone(lead.getCustomer().getCustomerPhone());
			        c.setCustomerEmail(lead.getCustomer().getCustomerEmail());
			        return customerRepository.save(c);
			    });
		lead.setCustomer(customer);
		Region region = regionRepository.findById(lead.getRegion().getRegionId()).orElseThrow();
		lead.setRegion(region);
		User manager = userRepository.findByRegionAndRole(
		        region,
		        UserRole.MANAGER
		);

		if (manager == null) {
		    throw new RuntimeException(
		            "No manager assigned to region: " + region.getRegionName()
		    );
		}
		lead.setManager(manager);
        return leadRepository.save(lead);
    }

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    public Lead getLeadById(Long id) {
        return leadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead not found"));
    }

    public Lead updateLead(Long id, Lead lead) {

        Lead existing = getLeadById(id);

        existing.setCustomer(lead.getCustomer());
        existing.setRegion(lead.getRegion());
        existing.setPropertyType(lead.getPropertyType());
        existing.setMeasurementUnit(lead.getMeasurementUnit());
        existing.setUnitValue(lead.getUnitValue());
        existing.setProject(lead.getProject());
        existing.setProperty(lead.getProperty());
        existing.setBudget(lead.getBudget());
        existing.setSource(lead.getSource());
        existing.setRemarks(lead.getRemarks());
        existing.setManager(lead.getManager());
        existing.setAgent(lead.getAgent());
        existing.setStatus(lead.getStatus());

        return leadRepository.save(existing);
    }

    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }

    public List<Lead> getLeadsByCustomer(Long customerId) {
        return leadRepository.findByCustomerCustomerId(customerId);
    }

    public List<Lead> getLeadsByManager(Long managerId) {
        return leadRepository.findByManagerUserId(managerId);
    }

    public List<Lead> getLeadsByAgent(Long agentId) {
        return leadRepository.findByAgentUserId(agentId);
    }

    public List<Lead> getLeadsByStatus(LeadStatus status) {
        return leadRepository.findByStatus(status);
    }

    public List<Lead> getActiveLeads() {
        return leadRepository.findByIsActiveTrue();
    }
    
    public List<Lead> getLeadsByRegion(Long regionId){
    	return leadRepository.findByRegionRegionId(regionId);
    }
    
    public List<Lead> getAssignedLeads(){
    	return leadRepository.findByAgentIsNotNull();
    }
    
    public List<Lead> getUnassignedLeads(){
    	return leadRepository.findByAgentIsNull();
    }
    
    public List<Lead> getAssignedLeadsByRegion(Long regionId) {
        return leadRepository.findByRegionRegionIdAndAgentIsNotNull(regionId);
    }

    public List<Lead> getUnassignedLeadsByRegion(Long regionId) {
        return leadRepository.findByRegionRegionIdAndAgentIsNull(regionId);
    }
    
    public Lead assignAgent(Long leadId, Long agentId) {

        Lead lead = leadRepository.findById(leadId)
                .orElseThrow();

        User agent = userRepository.findById(agentId)
                .orElseThrow();
        
        if(agent.getRole() != UserRole.AGENT) {
            throw new RuntimeException("User is not an agent");
        }

        lead.setAgent(agent);

        return leadRepository.save(lead);
    }
    
}