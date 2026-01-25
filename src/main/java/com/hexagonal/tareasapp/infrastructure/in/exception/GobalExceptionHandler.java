package com.hexagonal.tareasapp.infrastructure.in.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hexagonal.tareasapp.domain.exceptions.UserNotFoundException;

@RestControllerAdvice
public class GobalExceptionHandler {
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<?> handlerUserNotFoundException(UserNotFoundException ex){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + ex.getMessage());
  }
}
