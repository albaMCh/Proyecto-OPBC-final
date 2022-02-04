package com.albamch.userservice.service;

import com.albamch.modelcommons.models.users.Role;

import java.util.List;

public interface RoleService{

    void delete(Integer id);

    Role update(Role roles);

    Role save(Role roles);

    Role enableRole(Integer id);

    Role disableRole(Integer id);

    boolean assignUserToRole(Integer id, String roleName);

    boolean unAssignUserToRole(Integer id, String roleName);

    List<Role> findByName(String nombre);

    Role findById(Integer id);

    List<Role> findAll();
}
