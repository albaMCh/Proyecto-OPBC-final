package com.albamch.jpacommons.repository.users;

import com.albamch.modelcommons.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameIgnoreCase(String username);

    List<User> findByUsernameContainingIgnoreCase(String nombre);

    User findByEmailContainingIgnoreCase(String email);

    @Query(value = "UPDATE user SET user.enable = 1 WHERE user.id = ?1", nativeQuery = true)
    User setEnableUser (Integer userId);

    @Query(value = "UPDATE user SET user.enable = 0 WHERE user.id = ?1", nativeQuery = true)
    User setDisableUser (Integer userId);

}