package com.commercecore.api.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class Error {

    private String message;

    private String field;

    private HttpStatus status;
}
