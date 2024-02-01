package com.management.vently.service;

import com.management.vently.domain.DTO.*;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthResponse authenticate(AuthRequest request);
}
