package com.management.vently.domain.DTO;

public record RegisterRequest(
        String firstname,
        String lastname,
        String email,
        String password
) {
}
