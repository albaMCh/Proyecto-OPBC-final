package com.albamch.jpacommons.repository.users;

import com.albamch.modelcommons.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameIgnoreCase(String username);

    List<User> findByNameContainingIgnoreCase (String name);

    List<User> findByUsernameContainingIgnoreCase(String username);

    User findByEmailContainingIgnoreCase(String email);

}