package com.commercecore.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResponseStatusException ex) {
        ErrorResponse errors = new ErrorResponse();
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        errors.setError("Product not found");
        errors.setMessage(ex.getReason());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
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
