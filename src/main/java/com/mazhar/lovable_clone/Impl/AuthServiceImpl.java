package com.mazhar.lovable_clone.Impl;

import com.mazhar.lovable_clone.dto.auth.AuthResponse;
import com.mazhar.lovable_clone.dto.auth.LoginRequest;
import com.mazhar.lovable_clone.dto.auth.SignUpRequest;
import com.mazhar.lovable_clone.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signUp(SignUpRequest signUpRequest) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        return null;
    }
}
