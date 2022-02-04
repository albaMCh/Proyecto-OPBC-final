package com.albamch.studentsservice.controller;

import com.albamch.modelcommons.models.students.Tag;
import com.albamch.studentsservice.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    //GET

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tag> findById(@PathVariable("id") Integer id) {

        return new ResponseEntity<>(tagService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<Tag>> findAll (){

        return new ResponseEntity<>(tagService.findAll(), HttpStatus.OK);
    }

    //POST

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Tag> save(@RequestBody Tag tag) {

        return new ResponseEntity<>(tagService.save(tag), HttpStatus.OK);
    }

    @RequestMapping(value = "/assing", method = RequestMethod.POST)
    public ResponseEntity<Object> assingTagToStudent (@RequestParam("studentId") Integer studentId,
                                                      @RequestParam("tag") String tagName){

        HashMap<String, String> response = new HashMap<>();

        if(tagService.assignUserToRole(studentId, tagName)) {

            response.put("Asignando etiqueta a estudiante", tagService.findById(studentId).getName());
            response.put("Tag", tagName);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        response.put("No se ha asignado la etiqueta", tagName);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/unassign", method = RequestMethod.POST)
    public ResponseEntity<Object> unAssingTagToStudent (@RequestParam("studentId") Integer studentId,
                                                      @RequestParam("tag") String tagName){

        HashMap<String, String> response = new HashMap<>();

        if(tagService.unAssignUserToRole(studentId, tagName)) {

            response.put("Desasignando etiqueta a estudiante", tagService.findById(studentId).getName());
            response.put("Tag", tagName);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        response.put("No se ha desasignar la etiqueta", tagName);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //DELETE

    @RequestMapping(method = RequestMethod.DELETE)
    public  ResponseEntity<Object> delete(@RequestParam("id") Integer id){

        HashMap <String, String> response = new HashMap<>();

        if (tagService.delete(id)) {

            response.put("Borrado usuario con id: ", id.toString());

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        response.put("No existe usuario con id: ", id.toString());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTagByName (@RequestParam("name") String name){

        HashMap <String, String> response = new HashMap<>();

        if (tagService.delete(name)) {

            response.put("Borrado tag: ", name);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        response.put("No existe tag: ", name);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
