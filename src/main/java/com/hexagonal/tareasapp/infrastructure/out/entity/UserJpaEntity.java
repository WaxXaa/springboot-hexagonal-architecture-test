package com.hexagonal.tareasapp.infrastructure.out.entity;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "users")
public class UserJpaEntity {
  @Id
  @Column
  public UUID id;

  @Column(nullable = false, unique = true)
  @Email
  public String email;

  @Column
  public String name;

  public UserJpaEntity() {
    // Constructor sin parámetros requerido por JPA
  }

  public UserJpaEntity(UUID id, String email, String name) {
    this.id = id;
    this.email = email;
    this.name = name;
  }

  // createAt
}
