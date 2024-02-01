package com.management.vently.domain.DTO;

public record UserDTO(
        String firstname,
        String lastname,
        String email,
        String role
) {
}
