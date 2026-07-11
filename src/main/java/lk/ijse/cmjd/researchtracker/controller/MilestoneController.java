package lk.ijse.cmjd.researchtracker.controller;

import lk.ijse.cmjd.researchtracker.milestone.Milestone;
import lk.ijse.cmjd.researchtracker.milestone.MilestoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/milestones")
@CrossOrigin
public class MilestoneController {

    @Autowired
    private MilestoneService milestoneService;

    // Fix: Explicitly specify an empty string route so it catches direct /api/milestones
    @GetMapping("")
    public ResponseEntity<List<Milestone>> getAllMilestones() {
        try {
            List<Milestone> milestones = milestoneService.getAllMilestones();
            return ResponseEntity.ok(milestones);
        } catch (Exception e) {
// This prevents Hibernate database errors from showing up as a generic 403
            System.out.println("DATABASE ERROR IN MILESTONES: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Milestone>> getMilestonesByProject(@PathVariable String projectId) {
        return ResponseEntity.ok(milestoneService.getMilestonesByProject(projectId));
    }

    @PostMapping("/project/{projectId}")
    public ResponseEntity<Milestone> createMilestone(@PathVariable String projectId, @RequestBody Milestone milestone) {
        return ResponseEntity.ok(milestoneService.saveMilestone(projectId, milestone));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMilestone(@PathVariable String id) {
        milestoneService.deleteMilestone(id);
        return ResponseEntity.ok("Milestone deleted successfully.");
    }
}

