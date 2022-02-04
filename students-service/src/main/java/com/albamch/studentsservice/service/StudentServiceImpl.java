package com.albamch.studentsservice.service;

import com.albamch.errors.Exceptions.CustomErrorResponse;
import com.albamch.jpacommons.repository.students.StudentRepository;
import com.albamch.modelcommons.models.students.Student;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public boolean delete(Integer id) {

        if(studentRepository.existsById(id)){

            log.info("Borrando alumno con id: " + id);
            studentRepository.deleteById(id);

            return true;
        }

        log.error("No existe alumno con id; " + id);
        return false;
    }

    @Override
    public boolean delete(Student student) {

        if(studentRepository.existsById(student.getId())){

            log.info("Borrando alumno con id:" + student.getId());

        }

        log.error("No existe alumno con id:" + student.getId());
        return false;
    }

    @Override
    public Student save(Student student) {

        log.info("Guardando alumno");
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {

        return studentRepository.findAll();
    }

    @Override
    public List<Student> findByName(String username){

        log.info("Buscando usuario por nombre: " + username);
        return studentRepository.findByUsernameContainingIgnoreCase(username);
    }

    @Override
    public Student findById(Integer id) {

        log.info("Buscando alumno con id: " + id);
        return studentRepository.findById(id).orElseThrow(() -> new CustomErrorResponse(this.getClass(),
                "No existe registro con el id: " + id,
                "EntityNotFound"));
    }

    @Override
    public List<Student> findByCity(String city) {

        log.info("Buscando alumno por ciudad:" + city);
        return studentRepository.findByCity(city);
    }

    @Override
    public Student findByEmail(String email) {

        log.info("Buscando alumno por email:" + email);
        return studentRepository.findByEmailIgnoreCase(email);

    }

    @Override
    public Student findByPhone_number(String phone_number) {

        log.info("Buscando alumno por número de telefono:" + phone_number);
        return studentRepository.findByPhonenumber(phone_number);
    }

    @Override
    public List<Student> findByPresence(String presence) {

        log.info("Buscando estudiante por presencialidad:" + presence);
        return studentRepository.findByPresenceIgnoreCase(presence);

    }

    @Override
    public List<Student> findByMove(boolean move) {

        log.info("Buscar estudiante por traslado:");
        return studentRepository.findByMove(move);

    }

    @Override
    public List<Student> findByCityAndPresenceAndMove(String city, String presence, Boolean move) {

        log.info("Buscando por cuidad: %S , presencialidad: %S y trasalado: %S", city, presence, move);
        return studentRepository.findByCityIgnoreCaseAndPresenceIgnoreCaseAndMove(city, presence, move);
    }
}
