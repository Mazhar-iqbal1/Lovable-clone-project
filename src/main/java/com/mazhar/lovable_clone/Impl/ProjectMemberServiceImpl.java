package com.mazhar.lovable_clone.Impl;

import com.mazhar.lovable_clone.dto.member.MemberResponse;
import com.mazhar.lovable_clone.dto.member.updateMemberRoleRequest;
import com.mazhar.lovable_clone.service.ProjectMemberService;
import org.springframework.stereotype.Service;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public MemberResponse getProjectMembers(Long projectId, Long usedId) {
        return null;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, updateMemberRoleRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }
}
