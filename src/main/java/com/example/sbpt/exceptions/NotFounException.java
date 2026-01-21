package com.example.sbpt.exceptions;

import org.springframework.http.HttpStatus;

public class NotFounException extends BaseException{
    public NotFounException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
