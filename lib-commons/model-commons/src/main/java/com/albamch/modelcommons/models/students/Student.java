package com.albamch.modelcommons.models.students;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 70)
    private String name;

    @Column(length = 80)
    private String lastname;

    @Column(length = 13, unique = true, nullable = false)
    private String phonenumber;

    @Column(unique = true, length = 110, nullable = false)
    private String email;

    @Column(length = 55)
    private String country;

    @Column(length = 55)
    private String city;

    @Column
    private Boolean move = false;

    @Column(length = 20)
    private String presence;

    @Column
    private String pathtoimage;

    @Column
    private String pathtocv;

    @Column(length = 55)
    private String username;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "students_to_tags", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id","tag_id"})})
    @ToString.Exclude
    private List<Tag> tags;

    //Setters and Getters

    public void addTag (Tag tag){

        if(!this.tags.contains(tag)){

            tag.addStudent(this);
            this.tags.add(tag);
        }
    }

    public void removeTag(Tag tag){

        if(!this.tags.contains(tag)){

            tag.removeStudent(this);
            this.tags.remove(tag);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return id != null && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
