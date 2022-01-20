package com.albamch.userservice.mapper;

import com.albamch.modelscommons.models.users.User;
import com.albamch.userservice.DAO.UserRestoredPassword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class UserMapperTest {

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    void userToUserRestoredPassword() {

        User user = new User();
        user.setId(12);
        user.setPassword("1234");
        user.setEmail("test@tets.com");

        UserRestoredPassword userRestoredPassword = userMapper.userToUserRestoredPassword(user);

        Assertions.assertEquals(user.getEmail(), userRestoredPassword.getEmail());
        Assertions.assertEquals(user.getPassword(), userRestoredPassword.getPassword());
        Assertions.assertEquals(user.getId(), userRestoredPassword.getId());
    }
}