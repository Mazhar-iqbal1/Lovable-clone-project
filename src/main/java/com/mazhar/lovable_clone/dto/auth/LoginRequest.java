package com.mazhar.lovable_clone.dto.auth;

public record LoginRequest(
        String email,
        String passwordHash
) {
}
