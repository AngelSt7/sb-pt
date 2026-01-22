package com.example.sbpt.exceptions;

import org.springframework.http.HttpStatus;

public class SpaceAlreadyOccupiedException extends BaseException {
    public SpaceAlreadyOccupiedException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
