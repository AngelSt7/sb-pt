package com.example.sbpt.exceptions;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Configuration
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Map<String, Object>> exceptionHandler(BaseException ex){
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getCause());
        body.put("statusHttp", ex.getCodeHttp());
        body.put("date", ex.getTimestamp());
        return ResponseEntity.status(ex.getCodeHttp()).body(body);
    }

}
