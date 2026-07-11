package lk.ijse.cmjd.researchtracker.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public Document saveDocument(String projectId, Document document) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        document.setProject(project);
        return documentRepository.save(document);
    }

    public List<Document> getDocumentsByProject(String projectId) {
        return documentRepository.findByProjectId(projectId);
    }

    public void deleteDocument(String id) {
        documentRepository.deleteById(id);
    }
}
