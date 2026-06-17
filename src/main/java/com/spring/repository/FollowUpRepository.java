package com.spring.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.FollowUp;
import com.spring.entity.FollowUpStatus;

@Repository
public interface FollowUpRepository extends JpaRepository<FollowUp, Long> {

    List<FollowUp> findByLead_LeadId(Long leadId);

    List<FollowUp> findByAgent_UserId(Long agentId);
    
    List<FollowUp> findByFollowUpStatus(FollowUpStatus status);
    
    List<FollowUp> findByFollowupDateBetween(LocalDate from, LocalDate to);
}
