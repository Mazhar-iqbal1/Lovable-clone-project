package com.mazhar.lovable_clone.service;

import com.mazhar.lovable_clone.dto.project.ProjectRequest;
import com.mazhar.lovable_clone.dto.project.ProjectResponse;
import com.mazhar.lovable_clone.dto.project.ProjectSummaryResponse;
import org.jspecify.annotations.Nullable;

public interface ProjectService {
     ProjectSummaryResponse getUserProjects(Long userId);

     ProjectSummaryResponse getUserProjectById(Long userId);

     ProjectResponse createProject(ProjectRequest request, Long userId);

     ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

     void softDelete(Long userId);
}
