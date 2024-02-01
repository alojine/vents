package com.management.vently.service;

import com.management.vently.domain.DTO.AuthenticationRequest;
import com.management.vently.domain.DTO.AuthenticationResponse;
import com.management.vently.domain.DTO.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
