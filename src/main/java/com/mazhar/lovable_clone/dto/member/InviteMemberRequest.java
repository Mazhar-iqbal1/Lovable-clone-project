package com.mazhar.lovable_clone.dto.member;

import com.mazhar.lovable_clone.enums.ProjectMemberRole;

public record InviteMemberRequest(
        String email,
        ProjectMemberRole role
) {
}
