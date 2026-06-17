package com.spring.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.entity.SiteVisit;
import com.spring.services.SiteVisitServices;

@RestController
@RequestMapping("/api/sitevisits")
@CrossOrigin("*")
public class SiteVisitController {

    @Autowired
    private SiteVisitServices siteVisitService;

    @PostMapping
    public SiteVisit createSiteVisit(
            @RequestBody SiteVisit siteVisit) {

        return siteVisitService.createSiteVisit(siteVisit);
    }

    @GetMapping
    public List<SiteVisit> getAllSiteVisits() {

        return siteVisitService.getAllSiteVisits();
    }

    @GetMapping("/{id}")
    public SiteVisit getSiteVisitById(
            @PathVariable Long id) {

        return siteVisitService.getSiteVisitById(id);
    }

    @GetMapping("/lead/{leadId}")
    public List<SiteVisit> getByLeadId(
            @PathVariable Long leadId) {

        return siteVisitService.getByLeadId(leadId);
    }

    @GetMapping("/agent/{agentId}")
    public List<SiteVisit> getByAgentId(
            @PathVariable Long agentId) {

        return siteVisitService.getByAgentId(agentId);
    }

    @GetMapping("/date-range")
    public List<SiteVisit> getByDateRange(
            @RequestParam LocalDate from,
            @RequestParam LocalDate to) {

        return siteVisitService.getByDateRange(from, to);
    }

    @PutMapping("/{id}")
    public SiteVisit updateSiteVisit(
            @PathVariable Long id,
            @RequestBody SiteVisit siteVisit) {

        return siteVisitService.updateSiteVisit(id, siteVisit);
    }

    @DeleteMapping("/{id}")
    public void deleteSiteVisit(
            @PathVariable Long id) {

        siteVisitService.deleteSiteVisit(id);
    }
}
