package com.management.vently.service.Impl;

import com.management.vently.enums.VentlyError;
import com.management.vently.exception.VentlyUserNotFoundException;
import com.management.vently.model.User;
import com.management.vently.repository.UserRepository;
import com.management.vently.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new VentlyUserNotFoundException(VentlyError.INVALID_EMAIL.getMessage()));
    }
}
