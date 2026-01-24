package com.hexagonal.tareasapp.infrastructure.in.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hexagonal.tareasapp.domain.model.User;
import com.hexagonal.tareasapp.domain.port.in.UserUseCase;
import com.hexagonal.tareasapp.infrastructure.in.dto.CreateUserRequest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("/user")
@RestController
public class UserController {

  private final UserUseCase userUseCase;

  public UserController(UserUseCase userUseCase) {
    this.userUseCase = userUseCase;
  }

  @PostMapping("create")
  public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) {
    System.out.println("Request received - Name: " + request.name() + ", Email: " + request.email());
    User user = userUseCase.create(request.name(), request.email());
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }

  @GetMapping("all")
  public ResponseEntity<?> getMethodName() {
      List<User> users = userUseCase.listAllUsers();
      return new ResponseEntity<>(users, HttpStatus.OK);
  }

}
