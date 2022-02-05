package com.albamch.modelcommons.models.files;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "files")
public class FileModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column
    private String fileName;

    @Column
    private String fileType;

    @JsonIgnore
    @Lob
    private byte[] fileData;

    //Constructor

    public FileModel (){

    }

    public FileModel(String fileName, String fileType, byte[] fileData) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "id='" + id + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FileModel fileModel = (FileModel) o;
        return id != null && Objects.equals(id, fileModel.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
