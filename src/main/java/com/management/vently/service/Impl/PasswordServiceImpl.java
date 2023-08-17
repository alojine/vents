package com.management.vently.service.Impl;

import com.management.vently.model.Password;
import com.management.vently.repository.PasswordRepository;
import com.management.vently.service.PasswordService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PasswordServiceImpl implements PasswordService {

    public final PasswordRepository passwordRepository;

    public PasswordServiceImpl(PasswordRepository passwordRepository) {
        this.passwordRepository = passwordRepository;
    }


    @Override
    public List<Password> getAll() {
        return passwordRepository.findAll();
    }

    @Override
    public void save(Password password) {
        password.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        password.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        passwordRepository.save(password);
    }

    public void put(Password password) {
        Password updatedPassword = passwordRepository.getReferenceById(password.getId());
        updatedPassword.setApplicationName(password.getApplicationName());
        updatedPassword.setEmailAddress(password.getEmailAddress());
        updatedPassword.setPassword(password.getPassword());
        updatedPassword.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));

         passwordRepository.save(updatedPassword);
    }
}
