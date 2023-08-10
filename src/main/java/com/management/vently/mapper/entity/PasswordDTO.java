package com.management.vently.mapper.entity;

public record PasswordDTO(
        String applicationName,
        String emailAddress,
        String password
) {
}
