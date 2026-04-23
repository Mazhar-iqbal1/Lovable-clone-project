package com.mazhar.lovable_clone.service;

import com.mazhar.lovable_clone.dto.project.ProjectRequest;
import com.mazhar.lovable_clone.dto.project.ProjectResponse;
import com.mazhar.lovable_clone.dto.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {
     List<ProjectSummaryResponse> getUserProjects(Long userId);

     ProjectSummaryResponse getUserProjectById(Long id ,Long userId);

     ProjectResponse createProject(ProjectRequest request, Long userId);

     ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

     void softDelete(Long userId);
}
