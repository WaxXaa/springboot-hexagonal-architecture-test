package com.hexagonal.tareasapp.application.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hexagonal.tareasapp.domain.model.User;
import com.hexagonal.tareasapp.domain.port.in.UserUseCase;
import com.hexagonal.tareasapp.domain.port.out.UserRepositoryPort;


@Service
public class UserService implements UserUseCase {

  private final UserRepositoryPort userRepo;

  public UserService (UserRepositoryPort userRepo){
    this.userRepo = userRepo;
  }

  @Override
  public User create(String name, String email) {
      User user = new User(name, email);
      return userRepo.save(user);
  }

  @Override
  public List<User> listAllUsers() {
    return userRepo.getAll();
  }
}

