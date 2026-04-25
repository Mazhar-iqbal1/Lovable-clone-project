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

import java.time.Instant;
import java.util.List;

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
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        //Optional<List<ProjectResponse>> projectSummaryResponses =projectRepository.findAll();
//        return projectRepository.findAllAccessibleByUser(userId)
//                .stream()
//                .map(e ->projectMapper.toProjectSummaryResponse(e))
//                .collect(Collectors.toList());

        var projects=projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummmaryResponse(projects);
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {

        Project project=projectRepository.findAccessibleProjectByUser(id,userId).orElseThrow();
        return projectMapper.toProjectResponse(project);

//        this below one is also method to fetch (but i takes more api calls)
//        Project project=projectRepository.findById(id).orElseThrow();
//        if(project.getOwner().getId().equals(userId))
//            return projectMapper.toProjectSummaryResponse(project);



    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {

        User owner=userRepository.findById(userId).orElseThrow();
        Project project=Project.builder() //user Entity here
                .name(request.name()) //converted here from DTO to entity
                .owner(owner)
                .build();

        project=projectRepository.save(project); //used entity here , needs to convert to DTO

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {

        // Below method is used if you have n numbers of fields to update
        Project project=projectRepository.findAccessibleProjectByUser(id,userId).orElseThrow();
        projectMapper.toUpdateProject(request,project);
        project=projectRepository.save(project);
        return projectMapper.toProjectResponse(project);

        //Below is the one method we can use if fields is 1 or 2 to update( like req has only one field)
//        Project project=projectRepository.findAccessibleProjectByUser(id,userId).orElseThrow();
//        project.setName(request.name());
//        project=projectRepository.save(project);
//        return projectMapper.toProjectResponse(project);

    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project=getAccessibleProjectById(id, userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("You are not allowed to Delete!");
        }
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);

    }

    /// INTERNAL FUNCTIONS

    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectByUser(projectId, userId).orElseThrow();
    }
}
