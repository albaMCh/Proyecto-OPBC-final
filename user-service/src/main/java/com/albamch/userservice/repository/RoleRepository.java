package com.albamch.userservice.repository;

import com.albamch.modelscommons.models.users.Role;
import com.albamch.modelscommons.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    List<Role> findByNameContainingIgnoreCase(String nombre);

    @Query(value = "UPDATE role SET role.enable = 1 WHERE role.id = ?1", nativeQuery = true)
    Role setEnableRole (Integer roleId);

    @Query(value = "UPDATE role SET role.enable = 0 WHERE role.id = ?1", nativeQuery = true)
    Role setDisableRole (Integer roleId);

    /*@Query(value = "INSERT INTO users_to_roles ", nativeQuery = true)
    boolean assignUserToRole (Integer userId, Integer roleId);*/
}
