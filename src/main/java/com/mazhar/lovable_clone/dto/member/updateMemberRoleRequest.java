package com.mazhar.lovable_clone.dto.member;

import com.mazhar.lovable_clone.enums.ProjectMemberRole;

public record updateMemberRoleRequest(
        ProjectMemberRole role
) {
}
