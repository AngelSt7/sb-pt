package com.example.sbpt.exceptions;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Map<String, Object>> exceptionHanlder(BaseException ex){
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getCause());
        body.put("errorType",ex.getErrorType());
        body.put("httpStatus", ex.getHttpStatus());
        return ResponseEntity.status(ex.getHttpStatus()).body(body);
    }

}
;