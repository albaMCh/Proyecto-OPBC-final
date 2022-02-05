package com.albamch.jpacommons.repository.users;

import com.albamch.modelcommons.models.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByNameIgnoreCase(String nombre);

    @Modifying
    @Query(value = "INSERT INTO users_to_roles VALUES (?1,?2) ", nativeQuery = true)
    void assignUserToRole (Integer userId, Integer roleId);

    @Modifying
    @Query(value = "DELETE FROM users_to_roles WHERE user_id = ?1 and role_id = ?2", nativeQuery = true)
    void unAssignUserToRole (Integer userId, Integer roleId);
}
