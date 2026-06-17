package com.spring.services;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.FollowUp;
import com.spring.repository.FollowUpRepository;

@Service
public class FollowUpServices {

    @Autowired
    private FollowUpRepository followUpRepository;

    public FollowUp createFollowUp(FollowUp followUp) {
        followUp.setCreatedAt(LocalDateTime.now());
        return followUpRepository.save(followUp);
    }

    public List<FollowUp> getAllFollowUps() {
        return followUpRepository.findAll();
    }

    public FollowUp getFollowUpById(Long id) {
        return followUpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Follow-up not found"));
    }

    public List<FollowUp> getByLeadId(Long leadId) {
        return followUpRepository.findByLead_LeadId(leadId);
    }

    public List<FollowUp> getByAgentId(Long agentId) {
        return followUpRepository.findByAgent_UserId(agentId);
    }

    public List<FollowUp> getByDateRange(
            LocalDate from,
            LocalDate to) {

        return followUpRepository.findByFollowupDateBetween(from, to);
    }

    public FollowUp updateFollowUp(Long id, FollowUp followUp) {

        FollowUp existing = getFollowUpById(id);

        existing.setFollowupDate(followUp.getFollowupDate());
        existing.setNotes(followUp.getNotes());
        existing.setStatus(followUp.getStatus());
        existing.setUpdatedAt(LocalDateTime.now());

        return followUpRepository.save(existing);
    }

    public void deleteFollowUp(Long id) {
        followUpRepository.deleteById(id);
    }
}