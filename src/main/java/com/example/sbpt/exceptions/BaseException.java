package com.example.sbpt.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String  errorType;
    public BaseException(String message, HttpStatus httpStatus){
       super(message);
       this.httpStatus = httpStatus;
       this.errorType = httpStatus.name();
    }
}
