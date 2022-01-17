package com.albamch.userservice.controller;

import com.albamch.userservice.DAO.UserRestoredPassword;
import com.albamch.userservice.models.User;
import com.albamch.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> findById(@PathVariable("id") Integer id) {

        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/enable-user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> enableUser(@PathVariable("id") Integer id) {

        return new ResponseEntity<>(userService.enableUser(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/disable-user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> disableUser(@PathVariable("id") Integer id) {

        return new ResponseEntity<>(userService.disableUser(id), HttpStatus.OK);
    }

    //POST

    @RequestMapping(value = "/RestorePass", method = RequestMethod.POST)
    public ResponseEntity<UserRestoredPassword> getPassword(@RequestParam(value = "email") String email) {

        return new ResponseEntity<>(userService.getPassword(email), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User users) {

        return new ResponseEntity<>(userService.save(users), HttpStatus.OK);
    }

    @RequestMapping(value = "/name", method = RequestMethod.POST)
    public ResponseEntity<List<User>> findByName(@RequestParam(value = "nombre") String nombre) {

        return new ResponseEntity<>(userService.findByName(nombre), HttpStatus.OK);
    }

    @RequestMapping(value = "/SetPass", method = RequestMethod.POST)
    public ResponseEntity<User> setPassword(@RequestParam(value = "email") String email,
                                             @RequestParam(value = "pass") String pass) {
        return new ResponseEntity<>(userService.setPassword(email, pass), HttpStatus.OK);
    }

    @RequestMapping(value = "/username", method = RequestMethod.POST)
    public ResponseEntity<User> findByUsername(@RequestParam(value = "username") String username) {

        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public ResponseEntity<User> findByEmail(@RequestParam(value = "email") String email) {

        return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);
    }

    //PUT

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<User> update(@RequestBody User users) {

        return new ResponseEntity<>(userService.update(users), HttpStatus.OK);
    }

    //DELETE

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestParam("id") Integer id) {

        HashMap<String, String> response = new HashMap<>();

        if (userService.delete(id)) {

            response.put("Borrado usuario con id: ", id.toString());

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        response.put("No existe usuario con id: ", id.toString());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
