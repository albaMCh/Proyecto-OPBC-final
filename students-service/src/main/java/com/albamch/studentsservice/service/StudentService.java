package com.albamch.studentsservice.service;

import com.albamch.modelcommons.models.students.Student;

import java.util.List;

public interface StudentService {

    boolean delete (Integer id);

    boolean delete (Student student);

    Student save (Student student);

    List<Student> findAll ();

    List<Student> findByName(String username);

    Student findById (Integer id);

    List<Student> findByCity(String city);

    Student findByEmail(String email);

    Student findByPhone_number(String phone_number);

    List<Student> findByPresence(String presence);

    List<Student> findByMove (boolean move);

    List<Student> findByCityAndPresenceAndMove(String city, String presence, Boolean move);

}
