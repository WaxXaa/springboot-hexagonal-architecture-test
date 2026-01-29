package com.hexagonal.tareasapp.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hexagonal.tareasapp.domain.enums.Status;
import com.hexagonal.tareasapp.domain.exceptions.ProjectNotFoundException;
import com.hexagonal.tareasapp.domain.exceptions.TaskNotFoundException;
import com.hexagonal.tareasapp.domain.exceptions.UnauthorizeExeption;
import com.hexagonal.tareasapp.domain.model.Task;
import com.hexagonal.tareasapp.domain.port.in.TaskUseCase;
import com.hexagonal.tareasapp.domain.port.out.ProjectRepositoryPort;
import com.hexagonal.tareasapp.domain.port.out.TaskRepositoryPort;

@Service
public class TaskService implements TaskUseCase {
    
    private TaskRepositoryPort taskRepo;
    private ProjectRepositoryPort projectRepo;

    public TaskService(TaskRepositoryPort taskRepo, ProjectRepositoryPort projectRepo) {
        this.taskRepo = taskRepo;
        this.projectRepo = projectRepo;

    }

    @Override
    public Task create(String title, String description, UUID project_id){
        if (!projectRepo.existsById(project_id)) {
            throw new ProjectNotFoundException(project_id);
        }
        Task task = new Task(title, description, project_id);
        return taskRepo.save(task);
    }

    @Override
    public List<Task> listAll() {
        return taskRepo.findAll();
    }

    @Override
    public void deleteTask(UUID id, UUID projectId) {
        Optional<Task> istask = taskRepo.findById(id);
        if (!istask.isPresent()) 
            throw new TaskNotFoundException(id);
        Task task = istask.get();
        if (!(task.getProject_id() == projectId))
            throw new UnauthorizeExeption("No esta Autorizado para esto");
        projectRepo.deleteById(projectId);
    }

    @Override
    public Status changeStatus(Status status) {
        return null;
    }

    @Override
    public Task updateProject(UUID projectId, UUID ownerId, String name, String description) {
        
        return null;
    }

}
