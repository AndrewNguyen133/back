package com.backend.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.ZoneId;
import java.time.ZonedDateTime;

// need to annotate to say this class will be a handler
@RestControllerAdvice
public class ApiExceptionHandler {
    // to handle custom and existing exceptions, customize how we throw to the client
    // spring boot sends a default

    // need to tell Spring this method here will be responsible for the exception ApiRequestException
    // can pass 1 or more values in the value, if catching multiple exceptions then put them there
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        //1. Create a payload that you will send in the ResponseEntity
        //    the payload will contain the exception details
        HttpStatus status = HttpStatus.BAD_REQUEST;

        // if we are catching the ApiRequestException
        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                status,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        //2. Return response entity
        return new ResponseEntity<>(apiException, status);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {
        String errorMessageDescription = ex.getMessage();
        if (errorMessageDescription == null) errorMessageDescription = ex.toString();
        return null;
    }
}
