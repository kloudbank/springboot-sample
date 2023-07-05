package com.ski.tmpl.springboot.filter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionFilter {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleFileException() {
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }


}