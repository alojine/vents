package com.management.vently.service.Impl;

import com.management.vently.domain.model.Password;
import com.management.vently.domain.model.User;
import com.management.vently.exception.NotFoundException;
import com.management.vently.repository.PasswordRepository;
import com.management.vently.service.PasswordService;
import com.management.vently.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordServiceImpl implements PasswordService {

    public final PasswordRepository passwordRepository;

    public final UserService userService;

    public PasswordServiceImpl(PasswordRepository passwordRepository, UserService userService) {
        this.passwordRepository = passwordRepository;
        this.userService = userService;
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
    public List<Password> getPasswordsByUserId(Long id) {
        return passwordRepository.getPasswordsByUser(userService.getById(id))
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %s does not exist", id)));
    }
}
