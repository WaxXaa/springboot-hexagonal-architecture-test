package com.hexagonal.tareasapp.application.service;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hexagonal.tareasapp.domain.model.User;
import com.hexagonal.tareasapp.domain.port.in.CreateUserUseCase;
import com.hexagonal.tareasapp.domain.port.out.UserRepositoryPort;
@Service
public class CreateUserService implements CreateUserUseCase {

  private final UserRepositoryPort userRepo;

  public CreateUserService (UserRepositoryPort userRepo){
    this.userRepo = userRepo;
  }

  @Override
  public User create(String name, String email) {
      User user = new User(name, email);
      return userRepo.save(user);
  }
}

