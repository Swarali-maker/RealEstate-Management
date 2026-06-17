package com.spring.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "follow_ups")
public class FollowUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followupId;

    @ManyToOne
    @JoinColumn(name = "lead_id", nullable = false)
    private Lead lead;

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    private User agent;

    @Column(name="follow_up_date", nullable = false)
    private LocalDate followupDate;
    
    @Column(name="notes")
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(name="follow_up_status", nullable = false)
    private FollowUpStatus status;
    
    @Column(name="created_at", nullable=false)
    private LocalDateTime createdAt;
    
    @Column(name="updated_at")
	private LocalDateTime updatedAt;
    
    

	public FollowUp(Long followupId, Lead lead, User agent, LocalDate followupDate, String notes,
			FollowUpStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.followupId = followupId;
		this.lead = lead;
		this.agent = agent;
		this.followupDate = followupDate;
		this.notes = notes;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public FollowUp() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getFollowupId() {
		return followupId;
	}



	public void setFollowupId(Long followupId) {
		this.followupId = followupId;
	}



	public Lead getLead() {
		return lead;
	}



	public void setLead(Lead lead) {
		this.lead = lead;
	}



	public User getAgent() {
		return agent;
	}



	public void setAgent(User agent) {
		this.agent = agent;
	}



	public LocalDate getFollowupDate() {
		return followupDate;
	}



	public void setFollowupDate(LocalDate followupDate) {
		this.followupDate = followupDate;
	}



	public String getNotes() {
		return notes;
	}



	public void setNotes(String notes) {
		this.notes = notes;
	}



	public FollowUpStatus getStatus() {
		return status;
	}



	public void setStatus(FollowUpStatus status) {
		this.status = status;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}



	@Override
	public String toString() {
		return "FollowUp [followupId=" + followupId + ", lead=" + lead + ", agent=" + agent + ", followupDate="
				+ followupDate + ", notes=" + notes + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
}
