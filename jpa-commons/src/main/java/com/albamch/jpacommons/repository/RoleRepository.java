package com.albamch.jpacommons.repository;

import com.albamch.modelscommons.models.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    List<Role> findByNameContainingIgnoreCase(String nombre);
}
