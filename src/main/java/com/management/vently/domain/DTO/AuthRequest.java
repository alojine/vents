package com.management.vently.domain.DTO;

public record AuthRequest(
        String email,
        String password
) {
}
