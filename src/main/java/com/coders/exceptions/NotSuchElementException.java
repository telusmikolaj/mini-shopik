package com.coders.exceptions;

public class NotSuchElementException extends RuntimeException{
    public NotSuchElementException(String errorMessage) {
        super(errorMessage);
    }
}
