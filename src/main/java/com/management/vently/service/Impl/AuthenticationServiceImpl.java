package com.management.vently.service.Impl;

import com.management.vently.domain.DTO.*;
import com.management.vently.enums.Role;
import com.management.vently.domain.model.User;
import com.management.vently.exception.NotFoundException;
import com.management.vently.exception.RequestValidationException;
import com.management.vently.service.AuthenticationService;
import com.management.vently.service.JwtService;
import com.management.vently.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();

        userService.getByEmail(request.email()).ifPresent(existingUser -> {
            throw new RequestValidationException(String.format("User with email: %s already exists", existingUser.getEmail()));
        });


        userService.save(user);
        var jwtToken = jwtService.generateToken(user);
        return new AuthResponse(jwtToken);
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        User user = userService.getByEmail(request.email())
                .orElseThrow(() -> new NotFoundException(String.format("User with email: %s does not exist", request.email())));

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.email(),
                            request.password()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new NotFoundException(String.format("Invalid credentials for user with email: %s", request.email()));
        }

        var jwtToken = jwtService.generateToken(user);
        return new AuthResponse(jwtToken);
    }
}
