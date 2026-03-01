package com.example.StudentAPI.exception;

public class StudentNotFoundException extends RuntimeException{
	public StudentNotFoundException(String message) {
        super(message); // pass the message to the parent RuntimeException
    }
}
