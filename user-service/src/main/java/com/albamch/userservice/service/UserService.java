package com.albamch.userservice.service;

import com.albamch.userservice.models.User;

import java.util.List;

public interface UserService {

    boolean delete(Integer id);

    User save(User user);

    User update(User user);

    User findById(Integer id);

    User getPassword(String email);

    User setPassword(Integer id, String password);

    User enableUser(Integer id);

    User disableUser(Integer id);

    List<User> findByName(String nombre);

    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findAll();
}
