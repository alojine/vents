package com.management.vently.service;

import com.management.vently.model.Password;

import java.util.List;

public interface PasswordService {

    List<Password> getAll();

    Password save(Password password);
}
