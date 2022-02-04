package com.albamch.fileservice.service;

import com.albamch.errors.Exceptions.CustomErrorResponse;
import com.albamch.jpacommons.repository.files.FileRepository;
import com.albamch.modelcommons.models.files.FileModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Log4j2
@Service
public class FileServiceImple implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    public FileServiceImple(FileRepository fileRepository) {

        this.fileRepository = fileRepository;
    }

    @Override
    public FileModel save(MultipartFile file) {

        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        try {

            if (filename.contains("...")){

                throw new CustomErrorResponse(this.getClass(), "INVALID FILE", "File contains invalid characters");
            }

            log.info("Fichero guardado");
            FileModel model = new FileModel(filename, file.getContentType(), file.getBytes());
            return fileRepository.save(model);

        } catch (IOException e) {

            e.printStackTrace();
            log.error("No se ha podido guardar el fichero");
            throw new CustomErrorResponse(this.getClass(), "File Not Stored", e.getMessage());
        }
    }

    @Override
    public FileModel getFile(String fileId) {

        return fileRepository.findById(fileId).orElseThrow(() -> new CustomErrorResponse(this.getClass(), "File Not Found", "File Not Found"));
    }

    @Override
    public void deleteFile(String fileId) {

    }

    @Override
    public List<FileModel> findAll() {

        return fileRepository.findAll();
    }
}
