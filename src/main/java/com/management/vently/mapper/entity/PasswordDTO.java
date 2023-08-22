package com.management.vently.mapper.entity;

import com.management.vently.model.User;

public record PasswordDTO(
        String applicationName,
        String emailAddress,
        String password,
        User user
) {
}
