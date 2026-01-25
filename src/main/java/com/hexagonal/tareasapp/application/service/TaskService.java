package com.hexagonal.tareasapp.application.service;

import java.util.List;
import java.util.UUID;

import com.hexagonal.tareasapp.domain.enums.Status;
import com.hexagonal.tareasapp.domain.exceptions.ProjectNotFoundException;
import com.hexagonal.tareasapp.domain.model.Task;
import com.hexagonal.tareasapp.domain.port.in.TaskUseCase;
import com.hexagonal.tareasapp.domain.port.out.ProjectRepositoryPort;
import com.hexagonal.tareasapp.domain.port.out.TaskRepositoryPort;

public class TaskService implements TaskUseCase {
    
    private TaskRepositoryPort taskRepo;
    private ProjectRepositoryPort projectRepo;

    public TaskService(TaskRepositoryPort taskRepo, ProjectRepositoryPort projectRepo) {
        this.taskRepo = taskRepo;
        this.projectRepo = projectRepo;

    }

    @Override
    public Task create(String title, String description, Status status, UUID project_id){
        if (!projectRepo.existsById(project_id)) {
            throw new ProjectNotFoundException(project_id);
        }
        Task task = new Task(title, description, status, project_id);
        return taskRepo.save(task);
    }

    @Override
    public List<Task> listAllTasks() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Status changeStatus(Status status) {
        // TODO Auto-generated method stub
        return null;
    }

}
