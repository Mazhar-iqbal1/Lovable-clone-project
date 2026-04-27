package com.mazhar.lovable_clone.dto.auth;

import jakarta.validation.constraints.*;

public record LoginRequest(
        @NotBlank @Email String username,
        @Size(min = 4, max = 50) String password
) {
}
