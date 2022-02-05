package com.albamch.userservice.controller;

import com.albamch.modelcommons.models.users.Role;
import com.albamch.userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/role")
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

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Role> findByName(@PathVariable("name") String nombre){

        return new ResponseEntity<>(roleService.findByName(nombre), HttpStatus.OK);
    }

    @RequestMapping(value = "/enable/{id}", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, String>> enableRole (@PathVariable ("id") Integer id){

        HashMap<String, String> response = new HashMap<>();

        Role role = roleService.enableRole(id);

        response.put("Role: ", role.getName());
        response.put("Mensaje: ", "Esta activado");

        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/disable/{id}", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, String>> disableRole (@PathVariable ("id") Integer id){

        HashMap<String, String> response = new HashMap<>();

        Role role = roleService.disableRole(id);

        response.put("Role: ", role.getName());
        response.put("Mensaje: ", "Esta desactivado");

        return ResponseEntity.ok(response);
    }


    //POST

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Role> save (@RequestBody Role roles){

        return new ResponseEntity<>(roleService.save(roles), HttpStatus.OK);
    }

    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    public ResponseEntity<Object> assignRoleToUser (@RequestParam("user") Integer userId, @RequestParam("role") String roleName){

        HashMap<String, String> response = new HashMap<>();

        roleService.assignUserToRole(userId, roleName);

        response.put("Asignado role a usuario", userId.toString());
        response.put("Role ", roleName);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/unassign", method = RequestMethod.POST)
    public ResponseEntity<Object> unAssignRoleToUser (@RequestParam("user") Integer userId, @RequestParam("role") String roleName){

        HashMap<String, String> response = new HashMap<>();

        roleService.unAssignUserToRole(userId, roleName);

        response.put("Desasignado role a usuario", userId.toString());
        response.put("Role ", roleName);

        return new ResponseEntity<>(response, HttpStatus.OK);
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
