package com.management.vently.domain.DTO;

public record PasswordDTO(
        Long userId,
        String applicationName,
        String emailAddress,
        String password
) {
}
