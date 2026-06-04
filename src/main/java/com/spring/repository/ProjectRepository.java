package com.spring.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.*;
public interface ProjectRepository extends JpaRepository<Project, Long> {

    // Find by project name
    Optional<Project> findByProjectName(String projectName);

    // Check if project exists
    boolean existsByProjectName(String projectName);

    // Find by developer
    List<Project> findByDeveloperName(String developerName);

    // Find by region
    List<Project> findByRegion(Region region);

    // Find by region id
    List<Project> findByRegionRegionId(Long regionId);

    // Find by project type
    List<Project> findByProjectType(ProjectType projectType);

    // Find by project status
    List<Project> findByProjectStatus(ProjectStatus projectStatus);

    // Find active projects
    List<Project> findByIsActiveTrue();

    // Find active/inactive projects
    List<Project> findByIsActive(boolean isActive);

    // Find active projects by region
    List<Project> findByRegionRegionIdAndIsActiveTrue(Long regionId);

    // Find active projects by type
    List<Project> findByProjectTypeAndIsActiveTrue(ProjectType projectType);

    // Find active projects by status
    List<Project> findByProjectStatusAndIsActiveTrue(ProjectStatus projectStatus);

    // Search by project name
    List<Project> findByProjectNameContainingIgnoreCase(String projectName);

    // Search by developer name
    List<Project> findByDeveloperNameContainingIgnoreCase(String developerName);
}
