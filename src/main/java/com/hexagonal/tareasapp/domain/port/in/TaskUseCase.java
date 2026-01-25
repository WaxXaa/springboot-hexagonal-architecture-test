package com.hexagonal.tareasapp.domain.port.in;

import java.util.List;
import java.util.UUID;

import com.hexagonal.tareasapp.domain.enums.Status;
import com.hexagonal.tareasapp.domain.model.Task;

public interface TaskUseCase {
    public Task create(String title, String description, Status status, UUID project_id);
    public List<Task> listAllTasks();
    public Status changeStatus(Status status);
}
