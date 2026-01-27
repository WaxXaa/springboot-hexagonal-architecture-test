package com.hexagonal.tareasapp.domain.exceptions;

public class UnauthorizeExeption extends RuntimeException{
  public UnauthorizeExeption(String msg) {
    super(msg);
  }
}
