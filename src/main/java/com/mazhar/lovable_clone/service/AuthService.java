package com.mazhar.lovable_clone.service;

import com.mazhar.lovable_clone.dto.auth.AuthResponse;
import com.mazhar.lovable_clone.dto.auth.LoginRequest;
import com.mazhar.lovable_clone.dto.auth.SignUpRequest;
import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;

public interface AuthService {

  AuthResponse signUp(SignUpRequest signUpRequest);

  AuthResponse login(LoginRequest loginRequest);
}
