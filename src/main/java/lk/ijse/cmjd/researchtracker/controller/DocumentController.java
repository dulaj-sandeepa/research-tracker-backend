package lk.ijse.cmjd.researchtracker.controller;

import lk.ijse.cmjd.researchtracker.project.Document;
import lk.ijse.cmjd.researchtracker.project.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    // 1. UPLOAD/ADD DOCUMENT TO A PROJECT
    @PostMapping
    public Document addDocument(@PathVariable String projectId, @RequestBody Document document) {
        return documentService.saveDocument(projectId, document);
    }

    // 2. GET ALL DOCUMENTS FOR A SPECIFIC PROJECT
    @GetMapping
    public List<Document> getDocumentsByProject(@PathVariable String projectId) {
        return documentService.getDocumentsByProject(projectId);
    }

    // 3. DELETE A DOCUMENT
    @DeleteMapping("/{id}")
    public String deleteDocument(@PathVariable String id) {
        documentService.deleteDocument(id);
        return "Document removed successfully!";
    }
}

