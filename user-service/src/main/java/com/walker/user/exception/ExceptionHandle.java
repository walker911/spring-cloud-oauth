package com.walker.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author walker
 * @date 2018/12/21
 */
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(UserLoginException.class)
    public ResponseEntity<String> handleUserLoginException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }
}
