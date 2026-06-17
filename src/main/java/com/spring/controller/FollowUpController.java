package com.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.entity.FollowUp;
import com.spring.services.FollowUpServices;

@RestController
@RequestMapping("/api/followups")
@CrossOrigin("*")
public class FollowUpController {

    @Autowired
    private FollowUpServices followUpService;

    @PostMapping
    public FollowUp createFollowUp(
            @RequestBody FollowUp followUp) {

        return followUpService.createFollowUp(followUp);
    }

    @GetMapping
    public List<FollowUp> getAllFollowUps() {
        return followUpService.getAllFollowUps();
    }

    @GetMapping("/{id}")
    public FollowUp getFollowUpById(
            @PathVariable Long id) {

        return followUpService.getFollowUpById(id);
    }

    @GetMapping("/lead/{leadId}")
    public List<FollowUp> getByLeadId(
            @PathVariable Long leadId) {

        return followUpService.getByLeadId(leadId);
    }

    @GetMapping("/agent/{agentId}")
    public List<FollowUp> getByAgentId(
            @PathVariable Long agentId) {

        return followUpService.getByAgentId(agentId);
    }

    @GetMapping("/date-range")
    public List<FollowUp> getByDateRange(
            @RequestParam LocalDate from,
            @RequestParam LocalDate to) {

        return followUpService.getByDateRange(from, to);
    }

    @PutMapping("/{id}")
    public FollowUp updateFollowUp(
            @PathVariable Long id,
            @RequestBody FollowUp followUp) {

        return followUpService.updateFollowUp(id, followUp);
    }

    @DeleteMapping("/{id}")
    public void deleteFollowUp(
            @PathVariable Long id) {

        followUpService.deleteFollowUp(id);
    }
}
