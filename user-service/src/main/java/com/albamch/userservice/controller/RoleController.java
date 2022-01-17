package com.albamch.userservice.controller;

import com.albamch.userservice.models.Role;
import com.albamch.userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users/role")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    //GET

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Role>> findAll() {

        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Role> findById(@PathVariable("id") Integer id){

        return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> findByName(@RequestParam("nombre") String nombre){

        return new ResponseEntity<>(roleService.findByName(nombre), HttpStatus.OK);
    }

    //POST

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Role> save (@RequestBody Role roles){

        return new ResponseEntity<>(roleService.save(roles), HttpStatus.OK);
    }

    //PUT

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Role> update (@RequestBody Role roles){

        return new ResponseEntity<>(roleService.update(roles), HttpStatus.OK);
    }

    //DELETE

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<HashMap<String, String>> delete (@RequestParam("id") Integer id){

        roleService.delete(id);
        HashMap<String, String> response = new HashMap<>();
        response.put("usuario borrado",id.toString());

        return ResponseEntity.ok(response);
    }
}
