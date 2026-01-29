package com.hexagonal.tareasapp.infrastructure.out.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;

import com.hexagonal.tareasapp.domain.exceptions.ProjectNotFoundException;
import com.hexagonal.tareasapp.domain.model.Task;
import com.hexagonal.tareasapp.domain.port.out.TaskRepositoryPort;
import com.hexagonal.tareasapp.infrastructure.mapper.TaskMapper;
import com.hexagonal.tareasapp.infrastructure.out.entity.ProjectJpaEntity;
import com.hexagonal.tareasapp.infrastructure.out.entity.TaskJpaEntity;
import com.hexagonal.tareasapp.infrastructure.out.repository.ProjectJpaRepository;
import com.hexagonal.tareasapp.infrastructure.out.repository.TaskJpaRepository;

@Component
public class TaskJpaAdapter implements TaskRepositoryPort{

  private final TaskJpaRepository taskJpaRepository;
  private final ProjectJpaRepository projectJpaRepository;
  


  public TaskJpaAdapter(TaskJpaRepository taskJpaRepository, ProjectJpaRepository projectJpaRepository) {
    this.taskJpaRepository = taskJpaRepository;
    this.projectJpaRepository = projectJpaRepository;
  }

  @Override
  public void deleteById(UUID id) {
      taskJpaRepository.deleteById(id);
  }

  @Override
  public List<Task> findAll() {
    return taskJpaRepository.findAll().stream().map(TaskMapper::entityToTask).toList();
  }

  @Override
  public Optional<Task> findById(UUID id) {
    Optional<TaskJpaEntity> taskEntity = taskJpaRepository.findById(id);
    return taskEntity.map(TaskMapper::entityToTask);
  }

  @Override
  public Task save(Task task) {
    ProjectJpaEntity projectJpaEntity = projectJpaRepository.findById(task.getProject_id())
    .orElseThrow(() -> new ProjectNotFoundException(task.getProject_id()));
    return TaskMapper.entityToTask(taskJpaRepository.save(TaskMapper.taskToEntity(task, projectJpaEntity)));
  }
  
  
}
