package com.tuds.sss.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        // 1. Create payload containing exception details
        ApiException  apiException =
                new ApiException(e.getMessage(), ZonedDateTime.now(ZoneId.of("Z")));
        // 2. Return response entity
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
