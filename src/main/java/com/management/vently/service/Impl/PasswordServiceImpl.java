package com.management.vently.service.Impl;

import com.management.vently.model.Password;
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
    public Password save(Password password) {
        return passwordRepository.save(password);
    }
}
