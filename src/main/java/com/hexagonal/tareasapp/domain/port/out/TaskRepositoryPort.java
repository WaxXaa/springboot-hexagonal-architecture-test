package com.hexagonal.tareasapp.domain.port.out;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.hexagonal.tareasapp.domain.model.Task;

public interface TaskRepositoryPort {
    public Task save(Task task);
    public List<Task> findAll();
    public Optional<Task> findById(UUID id);
    public void deleteById(UUID id);
}
