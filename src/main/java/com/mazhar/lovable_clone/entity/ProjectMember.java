package com.mazhar.lovable_clone.entity;

import com.mazhar.lovable_clone.enums.ProjectMemberRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="project_members")
public class
ProjectMember {

    @EmbeddedId
    ProjectMemberId id;
    //created primary key using two fields projectId and userId - called Composite Id
    //TO uniquely identify row now you need both projectId and UserId, not like @Id which act as a primary key


    @ManyToOne
    @MapsId("projectId")
    Project project;

    @ManyToOne
    @MapsId("userId")
    User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ProjectMemberRole role;

    Instant invitedAt;
    Instant acceptedAt;



}
