package com.mazhar.lovable_clone.Impl;

import com.mazhar.lovable_clone.Mapper.AuthMapper;
import com.mazhar.lovable_clone.dto.auth.AuthResponse;
import com.mazhar.lovable_clone.dto.auth.LoginRequest;
import com.mazhar.lovable_clone.dto.auth.SignUpRequest;
import com.mazhar.lovable_clone.entity.User;
import com.mazhar.lovable_clone.error.BadRequestException;
import com.mazhar.lovable_clone.repository.UserRepository;
import com.mazhar.lovable_clone.security.AuthUtil;
import com.mazhar.lovable_clone.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final AuthMapper authMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthUtil authUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse signUp(SignUpRequest signUpRequest) {

        userRepository.findByUsername(signUpRequest.username()).ifPresent(user -> {
            throw new BadRequestException("User Already Exists with Username: " + signUpRequest.username());
        });

        User user=authMapper.toUserEntity(signUpRequest);
        user.setPassword(passwordEncoder.encode(signUpRequest.password()));
        user =userRepository.save(user);

        //Builder method we can use also but now on we are using MapStruct
//        User user = User.builder()
//                .name(signUpRequest.name())
//                .username(signUpRequest.username())
//                .password(signUpRequest.password())
//                .createdAt(Instant.now())
//                .updatedAt(Instant.now())
//                .build();

        String token = authUtil.generateAccessToken(user);

        return new AuthResponse(token,authMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {

        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(),loginRequest.password())
        );


        User user= (User) authentication.getPrincipal();
        String token= authUtil.generateAccessToken(user);

        return new AuthResponse(token,authMapper.toUserProfileResponse(user));
    }
}
