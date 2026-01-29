package com.hexagonal.tareasapp.infrastructure.in.controller;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hexagonal.tareasapp.domain.model.Project;
import com.hexagonal.tareasapp.domain.port.in.ProjectUseCase;
import com.hexagonal.tareasapp.infrastructure.in.dto.project.CreateProjectRequest;
import com.hexagonal.tareasapp.infrastructure.in.dto.project.DeleteProjectRequest;
import com.hexagonal.tareasapp.infrastructure.in.dto.project.UptadeProjectRequest;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("/project")
@RestController
public class ProjectController {
  private final ProjectUseCase projectUseCase;
  public ProjectController(ProjectUseCase projectUseCase) {
    this.projectUseCase = projectUseCase;
  }
  @PostMapping()
  public ResponseEntity<?> createProject(@Valid @RequestBody CreateProjectRequest request) {
    Project project = projectUseCase.create(request.name, request.description, request.ownerid);
    return new ResponseEntity<>(project, HttpStatus.CREATED);
  }
  @GetMapping()
  public ResponseEntity<?> getAllProjects() {
      List<Project> list = projectUseCase.listAll();
      return ResponseEntity.status(HttpStatus.OK).body(list);
  }
  @GetMapping("/{id}")
  public ResponseEntity<?> getMethodName(@PathVariable UUID id) {
      Project project = projectUseCase.findById(id);
      return ResponseEntity.status(HttpStatus.OK).body(project);
  }
  @DeleteMapping()
  public ResponseEntity<?> deleteProject(@Valid @RequestBody DeleteProjectRequest request){
    projectUseCase.deleteProjectByOwner(request.projecId, request.ownerId);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body("pryecto eliminado");
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> putMethodName(@PathVariable UUID id, @RequestBody UptadeProjectRequest request) {
      Project project = projectUseCase.updateProject(id, request.ownerId, request.name, request.description);
      return ResponseEntity.status(HttpStatus.OK).body(project);
  }
}
