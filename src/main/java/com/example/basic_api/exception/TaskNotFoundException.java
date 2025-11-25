package com.example.basic_api.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException() {}

    public TaskNotFoundException(String message) {
        super(message);
    }
}
