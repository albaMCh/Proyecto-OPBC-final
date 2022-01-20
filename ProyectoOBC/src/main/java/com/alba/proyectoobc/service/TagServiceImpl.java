package com.alba.proyectoobc.service;

import com.alba.proyectoobc.ExceptionHandler.CustomErrorResponse;
import com.alba.proyectoobc.models.Tag;
import com.alba.proyectoobc.repository.TagRepository;
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
        }

        log.error("No existe alumno con id;" + id);
        return false;
    }

    @Override
    public boolean delete(Tag tag) {

        if (tagRepository.existsById(tag.getId())) {

            log.info("Borrando alumno con id:" + tag.getId());
        }
         log.error("No exsite alumno con id:" + tag.getId());
        return false;
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


}


