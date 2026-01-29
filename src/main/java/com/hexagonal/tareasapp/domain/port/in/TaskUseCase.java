package com.hexagonal.tareasapp.domain.port.in;

import java.util.List;
import java.util.UUID;

import com.hexagonal.tareasapp.domain.enums.Status;
import com.hexagonal.tareasapp.domain.model.Task;

public interface TaskUseCase {
    public Task create(String title, String description, UUID project_id);
    public List<Task> listAll();
    public void deleteTask(UUID id, UUID projectId);
    public Status changeStatus(Status status);
    public Task updateProject(UUID projectId,UUID ownerId, String name, String description);
}
