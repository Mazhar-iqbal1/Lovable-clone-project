package com.mazhar.lovable_clone.Mapper;

import com.mazhar.lovable_clone.dto.member.MemberResponse;
import com.mazhar.lovable_clone.entity.ProjectMember;
import com.mazhar.lovable_clone.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "projectRole", constant = "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "projectRole", source = "role")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);

}
