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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

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
    @ResponseBody
    public ResponseEntity<List<ErrorResponse>> handleValidationException(MethodArgumentNotValidException exception){

        List<ErrorResponse> errors = new ArrayList<>();

        exception.getBindingResult().getAllErrors().forEach((error ->{
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setField(((FieldError) error).getField());
            errorResponse.setMessage(error.getDefaultMessage());
            errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            errorResponse.setError("Validation failed.");
            errors.add(errorResponse);
        } ));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ErrorResponse {
        private int status;
        private String error;
        private String message;
        private String field;
    }
}
