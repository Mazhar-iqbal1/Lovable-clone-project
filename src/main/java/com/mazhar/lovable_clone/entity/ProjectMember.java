package com.mazhar.lovable_clone.entity;

import com.mazhar.lovable_clone.enums.ProjectMemberRole;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class
ProjectMember {

    ProjectMemberId id;

    Project project;

    User user;

    ProjectMemberRole role;

    Instant invitedAt;
    Instant acceptedAt;


}
