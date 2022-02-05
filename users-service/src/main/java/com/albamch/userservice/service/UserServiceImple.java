package com.albamch.userservice.service;

import com.albamch.errors.Exceptions.CustomErrorResponse;
import com.albamch.jpacommons.repository.users.UserRepository;
import com.albamch.modelcommons.models.users.User;
import com.albamch.userservice.DAO.UserRestoredPassword;
import com.albamch.userservice.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class
UserServiceImple implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder cryptPasswordEncoder;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImple(UserRepository userRepository, BCryptPasswordEncoder cryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.cryptPasswordEncoder = cryptPasswordEncoder;
        this.userMapper = Mappers.getMapper(UserMapper.class);
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

        log.info("guardando usuario");

        user.setPassword(cryptPasswordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public UserRestoredPassword getPassword(String email) {

        User user = findByEmail(email);

        if(user != null){

            log.info("Usuario recuperando contraseña");
            return userMapper.userToUserRestoredPassword(user);
        }

        return null;
    }

    @Override
    public User setPassword(String email, String password) {

        log.info("Estableciendo contraseña para usuario: " + email);

        User users = findByEmail(email);

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

        log.info("buscando por usuario: " + nombre);
        return userRepository.findByNameContainingIgnoreCase(nombre);
    }

    @Override
    public User findByEmail(String email) {

        log.info("buscando por email: " + email);
        return userRepository.findByEmailContainingIgnoreCase(email);
    }

    @Override
    public User findByUsername(String username) {

        log.info("buscando usuario: " + username);
        return userRepository.findByUsernameIgnoreCase(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
