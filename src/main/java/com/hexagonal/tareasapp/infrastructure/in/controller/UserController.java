package com.hexagonal.tareasapp.infrastructure.in.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hexagonal.tareasapp.domain.model.User;
import com.hexagonal.tareasapp.domain.port.in.CreateUserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/user")
@RestController
public class UserController {

  private final CreateUserUseCase createUserUseCase;
  public UserController(CreateUserUseCase createUserUseCase){
    this.createUserUseCase = createUserUseCase;
  }
  @PostMapping("create")
  public ResponseEntity<?> postMethodName(@RequestBody String email, @RequestBody String name ) {
      //TODO: process POST request
      User user = createUserUseCase.create(name, email);
      return new ResponseEntity<>(user,HttpStatus.CREATED);
  }

}
