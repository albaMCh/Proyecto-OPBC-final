package com.alba.proyectoobc.service;

import com.alba.proyectoobc.models.Tag;

import java.util.List;

public interface TagService {

    boolean delete(Integer id);

    boolean delete(Tag tag);

    Tag save(Tag tag);

    List<Tag> findAll();

    Tag findById(Integer id);

}

