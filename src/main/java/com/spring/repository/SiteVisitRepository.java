package com.spring.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.entity.SiteVisit;
@Repository
public interface SiteVisitRepository extends JpaRepository<SiteVisit, Long> {

    List<SiteVisit> findByLead_LeadId(Long leadId);

    List<SiteVisit> findByAgent_UserId(Long agentId);
    
    List<SiteVisit> findByVisitDateBetween(LocalDate from, LocalDate to);
}
