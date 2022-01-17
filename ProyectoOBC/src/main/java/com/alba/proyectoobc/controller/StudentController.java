package com.alba.proyectoobc.controller;



import com.alba.proyectoobc.models.Student;
import com.alba.proyectoobc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {

    private StudentService studentService;


    @Autowired

    public StudentController (StudentService studentService) {this.studentService= studentService; }

    //GET

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findAll() {

        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> findById(@PathVariable("id") Integer id) {

        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public ResponseEntity<Student> findByEmail(@PathVariable ("email") String email){

        return new ResponseEntity<>(studentService.findByEmail(email), HttpStatus.OK);
    }

    @RequestMapping(value = "/city/{city}", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findByCity(@PathVariable ("city") String city){

        return new ResponseEntity<>(studentService.findByCity(city), HttpStatus.OK);
    }

    @RequestMapping(value = "/phoneNumber/{phoneNumber}", method = RequestMethod.GET)
    public ResponseEntity<Student> findByPhoneNumber(@PathVariable ("phoneNumber") String phoneNumber) {

        return new ResponseEntity<>(studentService.findByPhone_number(phoneNumber), HttpStatus.OK);
    }

    @RequestMapping(value = "/presence/{presence}", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findByPresence(@PathVariable ("presence") String presence){

        return new ResponseEntity<>(studentService.findByPresence(presence), HttpStatus.OK);
    }

    @RequestMapping(value = "/move/{move}", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findByMove(@PathVariable ("move") Boolean move){

        return new ResponseEntity<>(studentService.findByMove(move), HttpStatus.OK);
    }




    /*@RequestMapping(value = "/enable-student/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> enableStudent(@PathVariable("id") Integer id) {

        return new ResponseEntity<>(studentService.enableStudent(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/disable-user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> disableStudent(@PathVariable("id") Integer id) {

        return new ResponseEntity<>(studentService.disableStudent(id), HttpStatus.OK);
    }
*/
    //POST
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Student> save(@RequestBody Student student) {

        return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
    }

    @RequestMapping(value = "/name", method = RequestMethod.POST)
    public ResponseEntity<List<Student>> findByName(@RequestParam(value = "nombre") String nombre) {

        return new ResponseEntity<>(studentService.findByName(nombre), HttpStatus.OK);
    }

    @RequestMapping(value = "/3in1}", method = RequestMethod.POST)
    public ResponseEntity<List<Student>> findByCityAndPresenceAndMove (@RequestParam ("presence") String presence,
                                                                       @RequestParam ("city") String city,
                                                                       @RequestParam ("move") Boolean move ){

        return new ResponseEntity<>(studentService.findByCityAndPresenceAndMove(city, presence, move), HttpStatus.OK);
    }

    //DELETE

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestParam("id") Integer id) {

        HashMap<String, String> response = new HashMap<>();

        if (studentService.delete(id)) {

            response.put("Borrado usuario con id: ", id.toString());

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        response.put("No existe usuario con id: ", id.toString());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
