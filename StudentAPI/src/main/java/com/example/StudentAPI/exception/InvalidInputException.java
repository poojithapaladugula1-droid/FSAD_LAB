package com.example.StudentAPI.exception;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String message) {
        super(message); // pass the message to the parent RuntimeException
    }
}
