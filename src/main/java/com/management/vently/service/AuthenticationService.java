package com.management.vently.service;

import com.management.vently.domain.DTO.*;

public interface AuthenticationService {

    AuthResponse register(RegisterRequest request);

    AuthResponse authenticate(AuthRequest request);
}
