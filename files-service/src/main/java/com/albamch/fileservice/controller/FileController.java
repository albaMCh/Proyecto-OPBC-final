package com.albamch.fileservice.controller;

import com.albamch.fileservice.service.FileService;
import com.albamch.modelcommons.models.files.FileModel;
import com.albamch.modelcommons.models.files.FileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/file")
public class FileController {

    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public FileResponse uploadFile (@RequestParam("file")MultipartFile file){

        FileModel model = fileService.save(file);
        String fileURI = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads")
                .path(model.getId()).toUriString();

        return new FileResponse(model.getFileName(), model.getFileType(), fileURI);
    }

    @RequestMapping(value = "/uploads", method = RequestMethod.POST)
    public List<FileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files).
                stream().
                map(file -> uploadFile(file)).
                collect(Collectors.toList());
    }

    @RequestMapping(value = "/downloads/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("filename") String fileName) {
        FileModel model = fileService.getFile(fileName);
        return ResponseEntity.ok().
                header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + model.getFileName() + "\"").
                body(new ByteArrayResource(model.getFileData()));


    }

    @RequestMapping(method = RequestMethod.GET)
    public  List<FileModel>  getListFiles() {
        List<FileModel> fileDetails = fileService.findAll();

        return fileDetails;
    }
}
