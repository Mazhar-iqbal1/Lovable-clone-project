package com.mazhar.lovable_clone.Impl;

import com.mazhar.lovable_clone.Mapper.ProjectMemberMapper;
import com.mazhar.lovable_clone.dto.member.InviteMemberRequest;
import com.mazhar.lovable_clone.dto.member.MemberResponse;
import com.mazhar.lovable_clone.dto.member.updateMemberRoleRequest;
import com.mazhar.lovable_clone.entity.Project;
import com.mazhar.lovable_clone.entity.ProjectMember;
import com.mazhar.lovable_clone.entity.ProjectMemberId;
import com.mazhar.lovable_clone.entity.User;
import com.mazhar.lovable_clone.repository.ProjectMemberRepository;
import com.mazhar.lovable_clone.repository.ProjectRepository;
import com.mazhar.lovable_clone.repository.UserRepository;
import com.mazhar.lovable_clone.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;
    private final ProjectMemberMapper projectMemberMapper;
    private final UserRepository userRepository;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long usedId) {

        Project project = getAccessibleProjectById(projectId, usedId);
        List<MemberResponse> memberResponseList = new ArrayList<>();
        memberResponseList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner()));

        memberResponseList.addAll(
                projectMemberRepository.findByIdProjectId(projectId)
                        .stream()
                        .map(e -> projectMemberMapper.toProjectMemberResponseFromMember(e))
                        .toList());


        return memberResponseList;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, Long userId, InviteMemberRequest request) {

        Project project=getAccessibleProjectById(projectId,userId);

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not allowed");
        }

        User invitee=userRepository.findByEmail(request.email()).orElseThrow();

        if(invitee.getId().equals(userId)){
            throw  new RuntimeException("You are admin");
        }

        ProjectMemberId projectMemberId=new ProjectMemberId(projectId, invitee.getId());
        if(projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("You are already a Member!");
        }

        ProjectMember projectMember=ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .role(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, updateMemberRoleRequest request, Long userId) {

        Project project=getAccessibleProjectById(projectId,userId);

        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not allowed");
        }
        ProjectMemberId projectMemberId=new ProjectMemberId(projectId,memberId);

        ProjectMember projectMember=projectMemberRepository.findById(projectMemberId).orElseThrow();
        projectMember.setRole(request.role());
        projectMemberRepository.save(projectMember);


        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        Project project=getAccessibleProjectById(projectId, userId);
        ProjectMemberId projectMemberId=new ProjectMemberId(projectId, memberId);

        if(!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Project Member does not exists");
        }

        projectMemberRepository.deleteById(projectMemberId);


        return null;
    }

    /// INTERNAL FUNCTIONS

    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectByUser(projectId, userId).orElseThrow();
    }
}
