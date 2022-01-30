package com.alba.proyectoobc.service;

import com.alba.proyectoobc.models.FileModel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    FileModel save(MultipartFile file);

    FileModel getFile(String fileId);

    void deleteFile(String fileId);

    List<FileModel> findAll();
}
