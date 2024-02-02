package com.management.vently.service;

import com.management.vently.domain.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getByEmail(String email);

    User getById(Long id);

    void save(User user);
}
