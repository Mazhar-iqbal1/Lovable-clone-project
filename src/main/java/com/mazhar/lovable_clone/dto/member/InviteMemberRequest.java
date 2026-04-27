package com.mazhar.lovable_clone.dto.member;

import com.mazhar.lovable_clone.enums.ProjectMemberRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
        @Email
        @NotBlank
        String username,
        @NotNull ProjectMemberRole role
) {
}
