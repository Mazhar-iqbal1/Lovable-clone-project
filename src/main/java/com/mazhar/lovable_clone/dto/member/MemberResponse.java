package com.mazhar.lovable_clone.dto.member;

import com.mazhar.lovable_clone.enums.ProjectMemberRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String email,
        String  name,
        ProjectMemberRole projectRole,
        Instant invitedAt

) {
}
