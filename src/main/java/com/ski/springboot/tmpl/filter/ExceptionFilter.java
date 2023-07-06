package com.ski.springboot.tmpl.filter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ExceptionFilter {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleFileException(ResponseStatusException e) {
        return new ResponseEntity<Object>(e.getStatusCode());
    }


}