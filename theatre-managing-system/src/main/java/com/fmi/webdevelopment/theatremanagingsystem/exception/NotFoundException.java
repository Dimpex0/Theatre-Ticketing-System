package com.fmi.webdevelopment.theatremanagingsystem.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String entityName, Long id) {
        super(entityName + " not found with id: " + id);
    }
}