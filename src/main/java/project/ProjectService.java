package lk.ijse.cmjd.researchtracker.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }
    public Project getProjectById(String id) {
        return projectRepository.findById(id).orElse(null);
    }
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }
    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }

}
