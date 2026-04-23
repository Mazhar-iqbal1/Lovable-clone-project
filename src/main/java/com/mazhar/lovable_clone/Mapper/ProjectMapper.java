package com.mazhar.lovable_clone.Mapper;

import com.mazhar.lovable_clone.dto.project.ProjectResponse;
import com.mazhar.lovable_clone.dto.project.ProjectSummaryResponse;
import com.mazhar.lovable_clone.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);
    ProjectSummaryResponse toProjectSummaryResponse(Project project);


    List<ProjectSummaryResponse> toListOfProjectSummmaryResponse(List<Project> projects);
}
