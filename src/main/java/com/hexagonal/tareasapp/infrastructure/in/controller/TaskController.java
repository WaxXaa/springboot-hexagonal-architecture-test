package com.hexagonal.tareasapp.infrastructure.in.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hexagonal.tareasapp.domain.model.Task;
import com.hexagonal.tareasapp.domain.port.in.TaskUseCase;
import com.hexagonal.tareasapp.infrastructure.in.dto.CreateTaskRequest;
import com.hexagonal.tareasapp.infrastructure.in.dto.DeleteTaskRequest;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;




@RequestMapping("/task")
@RestController
public class TaskController {
  
  private final TaskUseCase taskUseCase;

  public TaskController(TaskUseCase taskUseCase) {
    this.taskUseCase = taskUseCase;
  }
  @PostMapping("/create")
  public ResponseEntity<?> createTask(@Valid @RequestBody CreateTaskRequest request) {
    Task task = taskUseCase.create(request.title, request.description, request.project_id);
      return new ResponseEntity<>(task, HttpStatus.CREATED);
  }

  @GetMapping("all")
  public ResponseEntity<?> getAllTasks() {
      List<Task> list = taskUseCase.listAll();
      return ResponseEntity.status(HttpStatus.OK).body(list);
  }

  @DeleteMapping()
  public ResponseEntity<?> deleteTask(@Valid @RequestBody DeleteTaskRequest request) {
    taskUseCase.deleteTask(request.id, request.projecId);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Tarea Eliminada");
  }
  
}
