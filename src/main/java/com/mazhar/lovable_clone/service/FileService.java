package com.mazhar.lovable_clone.service;

import com.mazhar.lovable_clone.dto.project.FileContentResponse;
import com.mazhar.lovable_clone.dto.project.FileNode;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FileService {
     List<FileNode> getFileTree(Long projectId, Long userId);


     FileContentResponse getFileContent(Long projectId, Long path, Long userId);
}
