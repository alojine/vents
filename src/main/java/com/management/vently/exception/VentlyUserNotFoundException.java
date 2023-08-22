package com.management.vently.exception;

public class VentlyUserNotFoundException extends RuntimeException {

    public VentlyUserNotFoundException(String message) {
        super(message);
    }

    public VentlyUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
