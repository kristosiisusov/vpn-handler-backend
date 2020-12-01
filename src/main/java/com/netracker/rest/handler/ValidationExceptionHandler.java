package com.netracker.rest.handler;

import com.netracker.exceptions.NotExistConstraintViolationException;
import com.netracker.rest.model.ConstraintViolationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ConstraintViolationModel>> handleConstraintViolation(ConstraintViolationException exception) {
        List<ConstraintViolationModel> violations = exception.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage).map(ConstraintViolationModel::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(violations, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotExistConstraintViolationException.class)
    public ResponseEntity<List<ConstraintViolationModel>> handleConstraintViolation(NotExistConstraintViolationException exception) {
        List<ConstraintViolationModel> violations = exception.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage).map(ConstraintViolationModel::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(violations, HttpStatus.NOT_FOUND);
    }
}
