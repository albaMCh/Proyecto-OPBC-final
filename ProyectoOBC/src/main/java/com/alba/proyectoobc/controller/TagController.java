package com.alba.proyectoobc.controller;

import com.alba.proyectoobc.models.Student;
import com.alba.proyectoobc.models.Tag;
import com.alba.proyectoobc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/tag")
public class TagController {

    private TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tag> findById(@PathVariable("id") Integer id) {

        return new ResponseEntity<>(tagService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public  ResponseEntity<Object> delete(@RequestParam("id") Integer id){

        HashMap <String, String> response = new HashMap<>();

        if (tagService.delete(id)) {

            response.put("Borrado usuario con id: ", id.toString());

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        response.put("No existe usuario con id: ", id.toString());

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Tag> save(@RequestBody Tag tag) {

        return new ResponseEntity<>(tagService.save(tag), HttpStatus.OK);
    }


    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<Tag>> findAll (){

        return new ResponseEntity<>(tagService.findAll(), HttpStatus.OK);
    }



}
