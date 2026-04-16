package com.mazhar.lovable_clone.dto.member;

import com.mazhar.lovable_clone.enums.ProjectMemberRole;

public record MemberResponse(
        Long id,
        String email,
        String  name,
        String avatarUrl,
        ProjectMemberRole role

) {
}
