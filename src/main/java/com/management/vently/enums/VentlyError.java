package com.management.vently.enums;

public enum VentlyError {
    INVALID_EMAIL("Invalid user email provided"),
    INVALID_USER("Invalid user provided"),
    NO_PASSWORD_FOUND("No password found");

    private final String message;

    VentlyError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
