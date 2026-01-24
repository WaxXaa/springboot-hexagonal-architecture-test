package com.hexagonal.tareasapp.application.service;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.hexagonal.tareasapp.domain.model.Project;
import com.hexagonal.tareasapp.domain.port.in.CreateProjectUseCase;
import com.hexagonal.tareasapp.domain.port.out.ProjectRepositoryPort;

@Service
public class CreateProjectService implements CreateProjectUseCase {

    private final ProjectRepositoryPort projectRepo;

    public CreateProjectService(ProjectRepositoryPort projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public Project create(String name, String description, UUID ownerId) {
        Project project = new Project(name, description, ownerId);
        return projectRepo.save(project);
    }
}