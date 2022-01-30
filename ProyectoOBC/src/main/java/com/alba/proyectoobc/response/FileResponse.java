package com.alba.proyectoobc.response;

import lombok.Data;

@Data
public class FileResponse {

    private String fileName;
    private String fileType;
    private String fileURI;

    public FileResponse(String fileName, String fileType, String fileURI) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileURI = fileURI;
    }

    @Override
    public String toString() {
        return "FileResponse{" +
                "fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileURI='" + fileURI + '\'' +
                '}';
    }
}
