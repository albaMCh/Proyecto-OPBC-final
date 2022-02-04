package com.albamch.jpacommons.repository.students;


import com.albamch.modelcommons.models.students.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByCity(String city);

    List<Student> findByUsernameContainingIgnoreCase (String username);

    Student findByEmailIgnoreCase(String email);

    Student findByPhonenumber(String phone_number);

    List<Student> findByPresenceIgnoreCase(String presence);

    List<Student> findByMove (boolean move);

    List<Student> findByCityIgnoreCaseAndPresenceIgnoreCaseAndMove (String city, String presence, Boolean move);

}
