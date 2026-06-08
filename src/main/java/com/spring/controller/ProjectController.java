package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Project;
import com.spring.entity.ProjectStatus;
import com.spring.entity.ProjectType;
import com.spring.services.ProjectsServices;
@CrossOrigin
@RestController
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectsServices projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectService.createProject(project));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(
            @PathVariable Long id,
            @RequestBody Project project) {

        return ResponseEntity.ok(
                projectService.updateProject(id, project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {

        projectService.deleteProject(id);

        return ResponseEntity.ok("Project deleted successfully");
    }

    @GetMapping("/region/{regionId}")
    public ResponseEntity<List<Project>> getProjectsByRegion(
            @PathVariable Long regionId) {

        return ResponseEntity.ok(
                projectService.getProjectsByRegion(regionId));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Project>> getProjectsByType(
            @PathVariable ProjectType type) {

        return ResponseEntity.ok(
                projectService.getProjectsByType(type));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Project>> getProjectsByStatus(
            @PathVariable ProjectStatus status) {

        return ResponseEntity.ok(
                projectService.getProjectsByStatus(status));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Project>> getActiveProjects() {
        return ResponseEntity.ok(
                projectService.getActiveProjects());
    }
}
