package com.management.vently.service;

import com.management.vently.domain.model.Password;
import com.management.vently.domain.model.User;

import java.util.List;

public interface PasswordService {

    Password getById(Long id);

    List<Password> getPasswordsByUserId(Long id);

    Password add(Password password, Long userId);

    Password update(Password password, Long userId);

    void delete(Long id);
}
