package com.mazhar.lovable_clone.service;

import com.mazhar.lovable_clone.dto.member.MemberResponse;
import com.mazhar.lovable_clone.dto.member.updateMemberRoleRequest;
import org.jspecify.annotations.Nullable;

public interface ProjectMemberService {
     MemberResponse getProjectMembers(Long projectId, Long usedId);

     MemberResponse inviteMember(Long projectId, Long userId);

     MemberResponse updateMemberRole(Long projectId, Long memberId, updateMemberRoleRequest request, Long userId);

     MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
