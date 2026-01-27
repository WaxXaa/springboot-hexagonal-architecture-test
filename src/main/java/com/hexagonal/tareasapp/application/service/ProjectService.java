package com.hexagonal.tareasapp.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.hexagonal.tareasapp.domain.exceptions.ProjectNotFoundException;
import com.hexagonal.tareasapp.domain.exceptions.UnauthorizeExeption;
import com.hexagonal.tareasapp.domain.exceptions.UserNotFoundException;
import com.hexagonal.tareasapp.domain.model.Project;
import com.hexagonal.tareasapp.domain.port.in.ProjectUseCase;
import com.hexagonal.tareasapp.domain.port.out.ProjectRepositoryPort;
import com.hexagonal.tareasapp.domain.port.out.UserRepositoryPort;

@Service
public class ProjectService implements ProjectUseCase {

    private final ProjectRepositoryPort projectRepo;
    private final UserRepositoryPort userRepo;

    public ProjectService(ProjectRepositoryPort projectRepo, UserRepositoryPort userRepo) {
        this.projectRepo = projectRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Project create(String name, String description, UUID ownerId) {
        if (!userRepo.userExists(ownerId)) {
            throw new UserNotFoundException(ownerId);
        }
        Project project = new Project(name, description, ownerId);
        return projectRepo.save(project);

    }

    @Override
    public List<Project> listAll() {
        return projectRepo.findAll();
    }

    @Override
    public void deleteProjectByOwner(UUID projectId, UUID ownerID) {
        Optional<Project> isproject = projectRepo.findById(projectId);
        if (!isproject.isPresent())
            throw new ProjectNotFoundException(projectId);
        Project project = isproject.get();

        if (!(project.getOwnerId() == ownerID))
            throw new UnauthorizeExeption("usuario no authorizado");
        projectRepo.deleteById(ownerID);
    }

    @Override
    public Project findById(UUID id) {
        Optional<Project> isproject = projectRepo.findById(id);
        if (!isproject.isPresent())
            throw new ProjectNotFoundException(id);
        return isproject.get();

    }

    @Override
    public Project updateProject(UUID projectId, UUID ownerId, String name, String description) {
        Optional<Project> projectOpt = projectRepo.findById(projectId);
        if(!projectOpt.isPresent())
            throw new ProjectNotFoundException(projectId);
        Project project = projectOpt.get();
        if (!userRepo.userExists(ownerId)) {
            throw new UserNotFoundException(ownerId);
        }
        if (!(project.getId() == ownerId))
            throw new UnauthorizeExeption("usuario no actualizado");
        project.setName(name);
        project.setDescription(description);
        return projectRepo.save(project);
    }
}