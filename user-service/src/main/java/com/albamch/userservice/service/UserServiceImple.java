package com.albamch.userservice.service;

import com.albamch.userservice.ExceptionHandler.CustomErrorResponse;
import com.albamch.userservice.models.User;
import com.albamch.userservice.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class UserServiceImple implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder cryptPasswordEncoder;

    @Autowired
    public UserServiceImple(UserRepository userRepository, BCryptPasswordEncoder cryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.cryptPasswordEncoder = cryptPasswordEncoder;
    }

    @Override
    public boolean delete(Integer id) {

        if (userRepository.existsById(id)) {

            log.info("Borrando usuario por id: " + id);
            userRepository.deleteById(id);

            return true;
        }

        log.error("No existe usuario con id: " + id);

        return false;
    }

    @Override
    public User save(User user) {

        log.info("guardando usuario con id: " + user.getId());
        return userRepository.save(user);
    }

    @Override
    public User setPassword(Integer id, String password) {

        log.info("Estableciendo contraseña para usuario: " + id);

        User users = findById(id);

        if (!password.equals("")) {

            users.setPassword(cryptPasswordEncoder.encode(password));
            return save(users);
        }

        return null;
    }

    @Override
    public User enableUser(Integer id) {

        log.info("Activando usuario con id: " + id);

        User users = findById(id);
        users.setEnable(true);
        return save(users);
    }

    @Override
    public User disableUser(Integer id) {

        log.info("Desactivando usuario con id: " + id);

        User users = findById(id);
        users.setEnable(false);
        return save(users);
    }

    @Override
    public User update(User user) {

        if ((user.getId() != null) && (userRepository.existsById(user.getId()))) {

            log.info("Actualizando con usuario con id: " + user.getId());

            userRepository.deleteById(user.getId());
            return userRepository.save(user);
        }

        log.info("Actualizando usuario");
        return userRepository.save(user);
    }

    @Override
    public User findById(Integer id) {

        log.info("buscando usuario por id: " + id);
        return userRepository.findById(id).orElseThrow(() -> new CustomErrorResponse(this.getClass(),
                "No existe registro con el id: " + id,
                "EntityNotFound"));
    }

    @Override
    public List<User> findByName(String nombre) {

        log.info("buscando role por usuario: " + nombre);
        return userRepository.findByUsernameContainingIgnoreCase(nombre);
    }

    @Override
    public User findByEmail(String email) {

        log.info("buscando por email: " + email);
        return userRepository.findByEmailContainingIgnoreCase(email);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsernameIgnoreCase(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
