package lk.ijse.cmjd.researchtracker.milestone;

import lk.ijse.cmjd.researchtracker.project.Project;
import lk.ijse.cmjd.researchtracker.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilestoneService {

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Milestone saveMilestone(String projectId, Milestone milestone) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + projectId));

        milestone.setProject(project);
        return milestoneRepository.save(milestone);
    }

    public List<Milestone> getMilestonesByProject(String projectId) {
        return milestoneRepository.findByProjectId(projectId);
    }

    public List<Milestone> getAllMilestones() {
        return milestoneRepository.findAll();
    }

    public void deleteMilestone(String id) {
        milestoneRepository.deleteById(id);
    }
}

