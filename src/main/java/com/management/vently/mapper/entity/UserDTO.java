package com.management.vently.mapper.entity;

public record UserDTO(
        String firstname,
        String lastname,
        String email,
        String role
) {
}
