package com.hexagonal.tareasapp.infrastructure.out.entity;


import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")

public class UserJpaEntity {
    @Id
    @Column
    @GeneratedValue
    @NotBlank
    public UUID id;

    @Column(nullable = false, unique = true)
    @Email
    public String email;

    @Column
    public String name;

    public UserJpaEntity(UUID id, String email, String name){
      this.id = id;
      this.email = email;
      this.name = name;
    }

    //createAt
  }
