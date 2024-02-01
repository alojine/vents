package com.management.vently.service;

import com.management.vently.domain.model.User;

import java.util.Optional;

public interface UserService {

    void save(User user);

    Optional<User> getByEmail(String email);
}
