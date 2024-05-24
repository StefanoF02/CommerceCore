package com.commercecore.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResponseStatusException ex) {
        ErrorResponse errors = new ErrorResponse();
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        errors.setError("Not found");
        errors.setMessage(ex.getReason());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException exception){

        Map<String,String> errors = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldname = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldname,errorMessage);
        });

        return errors;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ErrorResponse {
        private int status;
        private String error;
        private String message;
    }
}
