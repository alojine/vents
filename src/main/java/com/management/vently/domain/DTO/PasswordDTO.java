package com.management.vently.domain.DTO;

import com.management.vently.domain.model.User;

public record PasswordDTO(
        String applicationName,
        String emailAddress,
        String password,
        User user
) {
}
