package com.coders.exceptions;

public class TheSameNameException extends RuntimeException {
    public TheSameNameException(String errorMessage) {
        super(errorMessage);
    }
}
