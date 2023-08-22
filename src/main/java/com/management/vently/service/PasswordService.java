package com.management.vently.service;

import com.management.vently.model.Password;
import com.management.vently.model.User;

import java.util.List;

public interface PasswordService {

    List<Password> getAll();

    void save(Password password, User user);

    void put(Password password);

    List<Password> getAllByUser(User user);
}
