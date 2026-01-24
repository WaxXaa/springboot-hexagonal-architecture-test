package com.hexagonal.tareasapp.domain.port.in;

import java.util.List;

import com.hexagonal.tareasapp.domain.model.User;

public interface UserUseCase {

  public User create(String name, String email);
  public List<User> listAllUsers();

}
