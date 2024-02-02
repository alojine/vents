package com.management.vently.domain.DTO;

public record RegisterRequestDTO(
        String firstname,
        String lastname,
        String email,
        String password
) {
}
