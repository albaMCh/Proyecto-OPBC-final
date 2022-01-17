package com.albamch.userservice.repository;

import com.albamch.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameIgnoreCase(String username);

    List<User> findByUsernameContainingIgnoreCase(String nombre);

    User findByEmailContainingIgnoreCase(String email);
}