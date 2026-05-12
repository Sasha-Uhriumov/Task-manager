package com.sasha.task_manager.exception;

public class CustomStatusNotFoundException extends RuntimeException {
    public CustomStatusNotFoundException(String message) {
        super(message);
    }
}
