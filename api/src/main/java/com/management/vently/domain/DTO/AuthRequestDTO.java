package com.management.vently.domain.DTO;

public record AuthRequestDTO(
        String email,
        String password
) {
}
