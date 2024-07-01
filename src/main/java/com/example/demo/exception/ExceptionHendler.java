package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletException;

@ControllerAdvice
public class ExceptionHendler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> exceptionResponse(Exception ex)  {
       return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {AuthException.class, ServletException.class})
    public ResponseEntity<String> creadenzialiException(Exception ex)  {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.UNAUTHORIZED);
    }
}
