package com.albamch.modelcommons.models.students;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private List<Student> students;

    //Getters and Setters

    public void addStudent (Student student){

        if(!this.students.contains(student)){

            student.addTag(this);
            this.students.add(student);
        }
    }

    public void removeStudent (Student student){

        if(!this.students.contains(student)){

            student.removeTag(this);
            this.students.remove(student);
        }
    }
}
