package com.mazhar.lovable_clone.controller;

import com.mazhar.lovable_clone.dto.auth.AuthResponse;
import com.mazhar.lovable_clone.dto.auth.LoginRequest;
import com.mazhar.lovable_clone.dto.auth.SignUpRequest;
import com.mazhar.lovable_clone.dto.auth.UserProfileResponse;
import com.mazhar.lovable_clone.service.AuthService;
import com.mazhar.lovable_clone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("NullableProblems")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(SignUpRequest signUpRequest){

        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        return ResponseEntity.ok(userService.getProfile());
    }


}
