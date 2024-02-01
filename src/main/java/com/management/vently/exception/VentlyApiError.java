package com.management.vently.exception;

import java.time.LocalDateTime;

public record VentlyApiError(
        String path,
        String message,
        int statusCode,
        LocalDateTime dateTime
) {
}
