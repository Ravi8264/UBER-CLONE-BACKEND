package com.example.Uber.exception;

public class RuntineConflictException extends RuntimeException{
    public RuntineConflictException() {
    }

    public RuntineConflictException(String message) {
        super(message);
    }
}
