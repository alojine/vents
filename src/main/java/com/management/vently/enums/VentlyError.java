package com.management.vently.enums;

public enum VentlyError {
    INVALID_EMAIL("Invalid user email provided");

    private final String message;

    VentlyError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
