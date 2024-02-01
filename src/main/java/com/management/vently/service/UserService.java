package com.management.vently.service;

import com.management.vently.domain.model.User;

public interface UserService {

    void save(User user);

    User getByEmail(String email);
}
