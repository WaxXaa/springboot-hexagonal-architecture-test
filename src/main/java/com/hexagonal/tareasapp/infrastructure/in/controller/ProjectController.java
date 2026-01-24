package com.hexagonal.tareasapp.infrastructure.in.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexagonal.tareasapp.domain.model.Project;
import com.hexagonal.tareasapp.domain.port.in.ProjectUseCase;
import com.hexagonal.tareasapp.infrastructure.in.dto.CreateProjectRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/project")
@RestController
public class ProjectController {

  private final ProjectUseCase projectUseCase;

  public ProjectController(ProjectUseCase projectUseCase) {
    this.projectUseCase = projectUseCase;
  }

  @PostMapping("create")
  public ResponseEntity<?> createProject(@Valid @RequestBody CreateProjectRequest request) {
    Project project = projectUseCase.create(request.name, request.description, request.ownerid);
    return new ResponseEntity<>(project, HttpStatus.CREATED);
  }

  @GetMapping("all")
  public ResponseEntity<?> getAllProjects() {
      List<Project> list = projectUseCase.listAll();
      return ResponseEntity.status(HttpStatus.OK).body(list);
  }
}
