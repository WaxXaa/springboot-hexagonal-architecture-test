package com.hexagonal.tareasapp.application.service;
import java.util.UUID;
import com.hexagonal.tareasapp.domain.model.User;
import com.hexagonal.tareasapp.domain.port.in.CreateUserUseCase;
import com.hexagonal.tareasapp.domain.port.out.UserRepositoryPort;
public class CreateUserService implements CreateUserUseCase {

  private final UserRepositoryPort userRepo;

  public CreateUserService (UserRepositoryPort userRepo){
    this.userRepo = userRepo;
  }

  @Override
  public User create(UUID id, String name, String email) {
      User user = new User(id, name, email);
      return userRepo.save(user);
  }

}