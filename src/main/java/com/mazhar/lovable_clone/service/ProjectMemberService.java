package com.mazhar.lovable_clone.service;

import com.mazhar.lovable_clone.dto.member.InviteMemberRequest;
import com.mazhar.lovable_clone.dto.member.MemberResponse;
import com.mazhar.lovable_clone.dto.member.updateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
     List<MemberResponse> getProjectMembers(Long projectId, Long usedId);

     MemberResponse inviteMember(Long projectId, Long userId, InviteMemberRequest request);

     MemberResponse updateMemberRole(Long projectId, Long memberId, updateMemberRoleRequest request, Long userId);

     MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
