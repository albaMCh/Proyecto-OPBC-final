package com.albamch.studentsservice.service;

import com.albamch.errors.Exceptions.CustomErrorResponse;
import com.albamch.jpacommons.repository.students.TagRepository;
import com.albamch.modelcommons.models.students.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class TagServiceImpl implements TagService{

    private TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {

        this.tagRepository = tagRepository;
    }

    @Override
    public boolean delete(Integer id) {

        if(tagRepository.existsById(id)) {

            log.info("Borrado alumno con id:" + id);
            tagRepository.deleteById(id);
            return true;
        }

        log.error("No existe alumno con id;" + id);
        return false;
    }

    @Override
    public boolean delete(Tag tag) {

        if (tagRepository.existsById(tag.getId())) {

            log.info("Borrando alumno con id:" + tag.getId());
            return true;
        }

         log.error("No exsite alumno con id:" + tag.getId());
        return false;
    }

    @Override
    public boolean delete(String name) {

        log.info("Borrando etiqueta: " + name);
        return tagRepository.deleteTagByNameIgnoreCase(name);
    }

    @Override
    public boolean assignUserToRole(Integer stundentId, String tagName) {

        log.info("Asignando tag " + tagName + " a estudiante: " + stundentId);
        return tagRepository.assignTagToStudent(stundentId, findByName(tagName).get(0).getId());
    }

    @Override
    public boolean unAssignUserToRole(Integer stundentId, String tagName) {

        log.info("Desasignando tag " + tagName + " a estudiante: " + stundentId);
        return tagRepository.unAssignTagToStundent(stundentId, findByName(tagName).get(0).getId());
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findById(Integer id) {

        log.info("Buscando alumno con id:" + id);
        return tagRepository.findById(id).orElseThrow(() -> new CustomErrorResponse(this.getClass(),
                "No existe registro con el id:" + id, "EntityNotFound"));
    }

    @Override
    public List<Tag> findByName(String name) {

        log.info("Buscando tag por nombre: " + name);
        return tagRepository.findByNameContainingIgnoreCase(name);
    }
}


