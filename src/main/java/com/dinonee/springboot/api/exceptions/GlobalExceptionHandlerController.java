package com.dinonee.springboot.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFound(ResourceNotFoundException ex,
                                              HttpServletRequest request) {
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(new Date().getTime());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> badRequest(MethodArgumentNotValidException ex,
                                        HttpServletRequest request) {
        Error error = new Error();
        error.setMessage(Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(new Date().getTime());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> sqlViolations(SQLIntegrityConstraintViolationException ex,
                                           HttpServletRequest request) {
        Error error = new Error();
        error.setMessage(Objects.requireNonNull(ex.getMessage()));
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(new Date().getTime());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
