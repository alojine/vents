package com.management.vently.service.Impl;

import com.management.vently.domain.DTO.*;
import com.management.vently.enums.Role;
import com.management.vently.domain.model.User;
import com.management.vently.repository.UserRepository;
import com.management.vently.service.AuthenticationService;
import com.management.vently.service.JwtService;
import com.management.vently.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
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

        if (userService.getByEmail(request.email()).isEmpty()) {
            throw new
        }

        userService.save(user);
        var jwtToken = jwtService.generateToken(user);
        return new AuthResponse(jwtToken);
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        // TODO user service instead of repository
        var user = userService.getByEmail(request.email());

        var jwtToken = jwtService.generateToken(user);
        return new AuthResponse(jwtToken);
    }
}
