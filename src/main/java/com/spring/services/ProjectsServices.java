package com.spring.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Project;
import com.spring.entity.ProjectStatus;
import com.spring.entity.ProjectType;
import com.spring.repository.ProjectRepository;


@Service
public class ProjectsServices {
		@Autowired
	    private ProjectRepository projectRepository;

	    public Project createProject(Project project) {
	    	project.setCreatedAt(LocalDateTime.now());
	        return projectRepository.save(project);
	    }

	    public List<Project> getAllProjects() {
	        return projectRepository.findAll();
	    }

	    public Project getProjectById(Long id) {
	        return projectRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Project not found"));
	    }

	    public Project updateProject(Long id, Project project) {
	        Project existing = getProjectById(id);

	        existing.setProjectName(project.getProjectName());
	        existing.setDeveloperName(project.getDeveloperName());
	        existing.setRegion(project.getRegion());
	        existing.setProjectType(project.getProjectType());
	        existing.setProjectStatus(project.getProjectStatus());
	        existing.setAddress(project.getAddress());
	        existing.setDescription(project.getDescription());
	        existing.setTotalUnits(project.getTotalUnits());
	        existing.setLaunchDate(project.getLaunchDate());
	        existing.setExpectedCompletionDate(project.getExpectedCompletionDate());

	        return projectRepository.save(existing);
	    }

	    public void deleteProject(Long id) {
	        projectRepository.deleteById(id);
	    }

	    public List<Project> getProjectsByRegion(Long regionId) {
	        return projectRepository.findByRegionRegionId(regionId);
	    }

	    public List<Project> getProjectsByType(ProjectType type) {
	        return projectRepository.findByProjectType(type);
	    }

	    public List<Project> getProjectsByStatus(ProjectStatus status) {
	        return projectRepository.findByProjectStatus(status);
	    }

	    public List<Project> getActiveProjects() {
	        return projectRepository.findByIsActiveTrue();
	    }
}
