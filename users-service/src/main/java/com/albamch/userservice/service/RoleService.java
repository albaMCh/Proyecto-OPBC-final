package com.albamch.userservice.service;

import com.albamch.modelcommons.models.users.Role;

import java.util.List;

public interface RoleService{

    void delete(Integer id);

    Role update(Role roles);

    Role save(Role roles);

    Role enableRole(Integer id);

    Role disableRole(Integer id);

    void assignUserToRole(Integer id, String roleName);

    void unAssignUserToRole(Integer id, String roleName);

    Role findByName(String nombre);

    Role findById(Integer id);

    List<Role> findAll();
}
