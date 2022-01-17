package com.alba.proyectoobc.service;

import com.alba.proyectoobc.models.Student;

import java.util.List;

public interface StudentService {

    boolean delete (Integer id);

    boolean delete (Student student);

    Student save (Student student);

    List<Student> findAll ();

    List<Student> findByUsername(String username);

    Student findById (Integer id);

    List<Student> findByCity(String city);

    Student findByEmail(String email);

    Student findByPhone_number(String phone_number);

    List<Student> findByPresence(String presence);

    List<Student> findByMove (boolean move);

    List<Student> findByCityAndPresenceAndMove(String city, String presence, Boolean move);

}
