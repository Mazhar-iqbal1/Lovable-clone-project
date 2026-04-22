package com.mazhar.lovable_clone.Impl;

import com.mazhar.lovable_clone.Mapper.ProjectMapper;
import com.mazhar.lovable_clone.dto.project.ProjectRequest;
import com.mazhar.lovable_clone.dto.project.ProjectResponse;
import com.mazhar.lovable_clone.dto.project.ProjectSummaryResponse;
import com.mazhar.lovable_clone.entity.Project;
import com.mazhar.lovable_clone.entity.User;
import com.mazhar.lovable_clone.repository.ProjectRepository;
import com.mazhar.lovable_clone.repository.UserRepository;
import com.mazhar.lovable_clone.service.ProjectService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.userRepository=userRepository;
        this.projectMapper=projectMapper;
    }

    @Override
    public ProjectSummaryResponse getUserProjects(Long userId) {
        //Optional<List<ProjectResponse>> projectSummaryResponses =projectRepository.findAll();
        return null;
    }

    @Override
    public ProjectSummaryResponse getUserProjectById(Long userId) {
        return null;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner=userRepository.findById(userId).orElseThrow();
        Project project=Project.builder() //user Entity here
                .name(request.name())
                .owner(owner)
                .build();

        project=projectRepository.save(project); //used entity here , needs to convert to DTO

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public void softDelete(Long userId) {

    }
}
