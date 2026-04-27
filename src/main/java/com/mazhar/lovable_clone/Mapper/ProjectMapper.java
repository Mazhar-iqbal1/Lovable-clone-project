package com.mazhar.lovable_clone.Mapper;

import com.mazhar.lovable_clone.dto.project.ProjectRequest;
import com.mazhar.lovable_clone.dto.project.ProjectResponse;
import com.mazhar.lovable_clone.dto.project.ProjectSummaryResponse;
import com.mazhar.lovable_clone.entity.Project;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);
    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) //it ignore the null value coming from the request only change the field value sent by client
    void toUpdateProject(ProjectRequest projectRequest, @MappingTarget Project project);


    List<ProjectSummaryResponse> toListOfProjectSummmaryResponse(List<Project> projects);
}
