package com.albamch.userservice.service;

import com.albamch.modelcommons.models.users.User;
import com.albamch.userservice.DAO.UserRestoredPassword;

import java.util.List;

public interface UserService {

    boolean delete(Integer id);

    User save(User user);

    User update(User user);

    User findById(Integer id);

    UserRestoredPassword getPassword(String email);

    User setPassword(String email, String password);

    User enableUser(Integer id);

    User disableUser(Integer id);

    List<User> findByName(String nombre);

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findAll();
}
