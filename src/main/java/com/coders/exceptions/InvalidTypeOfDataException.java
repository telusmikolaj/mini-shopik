package com.coders.exceptions;

public class InvalidTypeOfDataException extends RuntimeException{
    public InvalidTypeOfDataException(String errorMessage) {
        super(errorMessage);
    }
}
