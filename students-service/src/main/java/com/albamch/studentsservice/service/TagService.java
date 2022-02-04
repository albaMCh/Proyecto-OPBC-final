package com.albamch.studentsservice.service;

import com.albamch.modelcommons.models.students.Tag;
import java.util.List;

public interface TagService {

    boolean delete(Integer id);

    boolean delete(Tag tag);

    boolean delete(String name);

    boolean assignUserToRole(Integer stundentId, String tagName);

    boolean unAssignUserToRole(Integer studentId, String tagName);

    Tag save(Tag tag);

    List<Tag> findAll();

    Tag findById(Integer id);

    List<Tag> findByName (String name);

}

