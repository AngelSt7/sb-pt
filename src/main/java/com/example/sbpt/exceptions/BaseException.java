package com.example.sbpt.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

@Getter
public class BaseException extends RuntimeException {
    private final HttpStatus codeHttp;
    private final OffsetDateTime timestamp;

    public BaseException(String message, HttpStatus codeHttp){
        super(message);
        this.codeHttp = codeHttp;
        this.timestamp = OffsetDateTime.now();
    }
}
