package com.coders.exceptions;

public class NoDataException extends RuntimeException {
    public NoDataException(String errorMessage) {
        super(errorMessage);
    }
}
