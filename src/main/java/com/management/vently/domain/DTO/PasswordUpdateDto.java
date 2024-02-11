package com.management.vently.domain.DTO;

public record PasswordUpdateDto(
        Long passwordId,
        Long userId,
        String applicationName,
        String emailAddress,
        String password
) {
}
