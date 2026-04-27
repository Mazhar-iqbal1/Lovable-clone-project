package com.mazhar.lovable_clone.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public record JwtUserPrincipalDto(
        Long userId,
        String username,
        List<GrantedAuthority> authorities
) {
}
