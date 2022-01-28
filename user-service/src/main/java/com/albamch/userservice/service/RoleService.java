package com.albamch.userservice.service;

import com.albamch.modelscommons.models.users.Role;

import java.util.List;

public interface RoleService{

    void delete(Integer id);

    Role update(Role roles);

    Role save(Role roles);

    Role enableRole(Integer id);

    Role disableRole (Integer id);

    List<Role> findByName(String nombre);

    Role findById(Integer id);

    List<Role> findAll();
}
