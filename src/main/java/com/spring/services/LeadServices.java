package com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Lead;
import com.spring.entity.LeadStatus;
import com.spring.repository.LeadRepository;

@Service
public class LeadServices {
	@Autowired
    private LeadRepository leadRepository;


	public Lead createLead(Lead lead) {
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
}