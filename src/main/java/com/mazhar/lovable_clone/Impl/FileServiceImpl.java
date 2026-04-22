package com.mazhar.lovable_clone.Impl;

import com.mazhar.lovable_clone.dto.project.FileContentResponse;
import com.mazhar.lovable_clone.dto.project.FileNode;
import com.mazhar.lovable_clone.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, Long path, Long userId) {
        return null;
    }
}
