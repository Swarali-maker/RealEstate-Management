package com.spring.services;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.SiteVisit;
import com.spring.repository.SiteVisitRepository;

@Service
public class SiteVisitServices {

    @Autowired
    private SiteVisitRepository siteVisitRepository;

    public SiteVisit createSiteVisit(SiteVisit siteVisit) {

        siteVisit.setCreatedAt(LocalDateTime.now());

        return siteVisitRepository.save(siteVisit);
    }

    public List<SiteVisit> getAllSiteVisits() {
        return siteVisitRepository.findAll();
    }

    public SiteVisit getSiteVisitById(Long id) {

        return siteVisitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Site visit not found"));
    }

    public List<SiteVisit> getByLeadId(Long leadId) {

        return siteVisitRepository.findByLead_LeadId(leadId);
    }

    public List<SiteVisit> getByAgentId(Long agentId) {

        return siteVisitRepository.findByAgent_UserId(agentId);
    }

    public List<SiteVisit> getByDateRange(
            LocalDate from,
            LocalDate to) {

        return siteVisitRepository.findByVisitDateBetween(from, to);
    }

    public SiteVisit updateSiteVisit(
            Long id,
            SiteVisit siteVisit) {

        SiteVisit existing = getSiteVisitById(id);

        existing.setVisitDate(siteVisit.getVisitDate());
        existing.setFeedback(siteVisit.getFeedback());
        existing.setStatus(siteVisit.getStatus());
        existing.setUpdatedAt(LocalDateTime.now());

        return siteVisitRepository.save(existing);
    }

    public void deleteSiteVisit(Long id) {
        siteVisitRepository.deleteById(id);
    }
}
