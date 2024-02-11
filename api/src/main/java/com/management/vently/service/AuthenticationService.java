package com.management.vently.service;

import com.management.vently.domain.DTO.*;

public interface AuthenticationService {

    AuthResponseDTO register(RegisterRequestDTO request);

    AuthResponseDTO authenticate(AuthRequestDTO request);
}
