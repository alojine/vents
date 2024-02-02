package com.management.vently.service.Impl;

import com.management.vently.domain.model.User;
import com.management.vently.exception.NotFoundException;
import com.management.vently.repository.UserRepository;
import com.management.vently.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User with Id: %s does not exist", id)));
    }
}
