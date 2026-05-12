package com.sasha.task_manager.exception;

public class CustomTaskNotFoundException extends RuntimeException {
    public CustomTaskNotFoundException(String message) {
        super(message);
    }
}
