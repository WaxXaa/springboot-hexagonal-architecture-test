package com.hexagonal.tareasapp.domain.port.out;
import com.hexagonal.tareasapp.domain.model.User;
import java.util.List;

public interface UserRepositoryPort {
  public User save(User user);
  public List<User> getAll();
}
