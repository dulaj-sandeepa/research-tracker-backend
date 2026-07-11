package lk.ijse.cmjd.researchtracker.controller;

import lk.ijse.cmjd.researchtracker.project.Project;
import lk.ijse.cmjd.researchtracker.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // 1. CREATE NEW PROJECT
    @PostMapping
    public Project saveProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    // 2. GET ALL PROJECTS
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    // 3. GET PROJECT BY ID
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable String id) {
        return projectService.getProjectById(id);
    }

    // 4. UPDATE FULL PROJECT DETAILS
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable String id, @RequestBody Project project) {
        project.setId(id);
        return projectService.updateProject(project);
    }

    // 5. DELETE A PROJECT
    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable String id) {
        projectService.deleteProject(id);
        return "Project with ID " + id + " has been deleted successfully!";
    }
    // 6. PATCH / UPDATE PROJECT STATUS ONLY
    @PatchMapping("/{id}/status")
    public Project updateProjectStatus(@PathVariable String id, @RequestBody java.util.Map<String, String> statusUpdate) {
        Project project = projectService.getProjectById(id);
        project.setStatus(statusUpdate.get("status"));
        return projectService.updateProject(project);
    }
}
