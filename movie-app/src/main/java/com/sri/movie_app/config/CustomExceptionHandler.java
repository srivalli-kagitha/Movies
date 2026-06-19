package com.sri.movie_app.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sri.movie_app.config.exceptions.InvalidPasswordException;
import com.sri.movie_app.config.exceptions.UserNotFoundException;
import com.sri.movie_app.dto.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(InvalidPasswordException.class)
    public String handleInvalidPasswordException(InvalidPasswordException exception){
        return exception.getMessage();
    }
    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(UserNotFoundException exception){
        return exception.getMessage();
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleExceeption(Exception exception){
        return ResponseEntity.status(400).body(new ErrorResponse(exception.getMessage()));
    }
}
