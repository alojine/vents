package com.management.vently.service.Impl;

import com.management.vently.domain.model.Password;
import com.management.vently.domain.model.User;
import com.management.vently.exception.NotFoundException;
import com.management.vently.exception.RequestValidationException;
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
    public Password getById(Long id) {
        return null;
    }

    @Override
    public List<Password> getPasswordsByUserId(Long id) {
        return passwordRepository.getPasswordsByUser(userService.getById(id))
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %s does not exist", id)));
    }

    @Override
    public Password add(Password password, Long userId) {
        password.setUser(userService.getById(userId));
        return passwordRepository.save(password);
    }

    @Override
    public Password update(Password password, Long userId) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Password password = getById(id);
        passwordRepository.delete(password);
    }

}
