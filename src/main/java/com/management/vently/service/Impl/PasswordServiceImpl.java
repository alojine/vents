package com.management.vently.service.Impl;

import com.management.vently.domain.DTO.PasswordUpdateDto;
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
        return passwordRepository.getPasswordById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Password with Id: %s was not found", id)));
    }

    @Override
    public List<Password> getPasswordsByUserId(Long id) {
        return passwordRepository.getPasswordsByUser(userService.getById(id))
                .orElseThrow(() -> new NotFoundException(String.format("User with id: %s does not exist", id)));
    }

    @Override
    public Password add(Password password, Long userId) {
        boolean isAlreadyUsed = passwordRepository.findAll().stream().anyMatch(existingPassword ->
                existingPassword.getApplicationName().equals(password.getApplicationName()) &&
                        existingPassword.getEmailAddress().equals(password.getEmailAddress()));

        if (isAlreadyUsed) {
            throw new RequestValidationException(
                    String.format("Password for application: %s with email: %s is already existing", password.getApplicationName(), password.getEmailAddress()));
        }

        password.setUser(userService.getById(userId));
        return passwordRepository.save(password);
    }

    @Override
    public Password update(PasswordUpdateDto passwordDto, Long userId) {
        Password existingPassword = getById(passwordDto.passwordId());
        if (!userService.getById(userId).equals(userService.getById(passwordDto.userId()))) {
            throw new RequestValidationException("Only password owner can update the password");
        }
        existingPassword.setApplicationName(passwordDto.applicationName());
        existingPassword.setEmailAddress(passwordDto.emailAddress());
        existingPassword.setPassword(passwordDto.password());

        return passwordRepository.saveAndFlush(existingPassword);
    }

    @Override
    public void delete(Long id) {
        Password password = getById(id);
        passwordRepository.delete(password);
    }

}
