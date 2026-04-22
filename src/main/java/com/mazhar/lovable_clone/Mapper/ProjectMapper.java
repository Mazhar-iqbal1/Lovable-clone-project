package com.mazhar.lovable_clone.Mapper;

import com.mazhar.lovable_clone.dto.project.ProjectResponse;
import com.mazhar.lovable_clone.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);
}
