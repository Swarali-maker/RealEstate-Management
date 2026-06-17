package com.spring.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findByLead_LeadId(Long leadId);
    
    Optional<Booking> findByAgent_AgentId(Long agentId);
    
    List<Booking> findByBookingDateBetween(LocalDate from, LocalDate to);
}