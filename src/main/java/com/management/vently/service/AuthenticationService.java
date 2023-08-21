package com.management.vently.service;

import com.management.vently.controller.auth.entity.AuthenticationRequest;
import com.management.vently.controller.auth.entity.AuthenticationResponse;
import com.management.vently.controller.auth.entity.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
