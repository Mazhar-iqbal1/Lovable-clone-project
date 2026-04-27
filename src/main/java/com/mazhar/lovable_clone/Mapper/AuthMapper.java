package com.mazhar.lovable_clone.Mapper;

import com.mazhar.lovable_clone.dto.auth.AuthResponse;
import com.mazhar.lovable_clone.dto.auth.SignUpRequest;
import com.mazhar.lovable_clone.dto.auth.UserProfileResponse;
import com.mazhar.lovable_clone.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    User toUserEntity(SignUpRequest signUpRequest);
    @Mapping(target = "name", source = "user.name")
    UserProfileResponse toUserProfileResponse(User user);

}
