package com.barros.gestao_de_treinos.resources.exceptions;

import com.barros.gestao_de_treinos.services.exceptions.DatabaseException;
import com.barros.gestao_de_treinos.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> handleValidationExceptions(ConstraintViolationException ex, HttpServletRequest request) {
        String erro = "Erro de validação";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = "Um ou mais campos estão inválidos";
        List<String> errors = ex.getConstraintViolations()
                .stream()
                .map(this::formatViolation)
                .toList();
        StandardError err = new StandardError(Instant.now(), status.value(), erro, message,
                request.getRequestURI(), errors);
        return ResponseEntity.status(status).body(err);
    }

    private String formatViolation(ConstraintViolation<?> violation) {
        String propertyPath = violation.getPropertyPath().toString();
        String parameterName = propertyPath.substring(propertyPath.lastIndexOf('.') + 1);

        return String.format("%s: %s.", parameterName, violation.getMessage());
    }
}
