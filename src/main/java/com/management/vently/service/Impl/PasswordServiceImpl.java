package com.management.vently.service.Impl;

import com.management.vently.enums.VentlyError;
import com.management.vently.domain.model.Password;
import com.management.vently.domain.model.User;
import com.management.vently.repository.PasswordRepository;
import com.management.vently.service.PasswordService;
import org.springframework.stereotype.Service;

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
    public void save(Password password, User user) {
        password.setUser(user);
        passwordRepository.save(password);
    }

    @Override
    public void put(Password password) {
        Password updatedPassword = passwordRepository.getReferenceById(password.getId());
        updatedPassword.setApplicationName(password.getApplicationName());
        updatedPassword.setEmailAddress(password.getEmailAddress());
        updatedPassword.setPassword(password.getPassword());

         passwordRepository.save(updatedPassword);
    }

    @Override
    public List<Password> getAllByUser(User user) {
        return passwordRepository.findAllByUser(user)
                .orElseThrow(() -> new VentlyUserNotFoundException(VentlyError.NO_PASSWORD_FOUND + " " + VentlyError.INVALID_USER));
    }
}
