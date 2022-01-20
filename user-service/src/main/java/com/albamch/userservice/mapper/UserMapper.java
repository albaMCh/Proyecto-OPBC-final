package com.albamch.userservice.mapper;

import com.albamch.modelscommons.models.users.User;
import com.albamch.userservice.DAO.UserRestoredPassword;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserMapper {

    @Mappings(
            {@Mapping(target = "id", source = "user.id")
            ,@Mapping(target = "email" , source = "user.email")
            ,@Mapping(target = "password", source = "user.password")})
    UserRestoredPassword userToUserRestoredPassword (User user);

    @Mappings(
            {@Mapping(target = "id", source = "userRestoredPassword.id")
            ,@Mapping(target = "email" , source = "userRestoredPassword.email")
            ,@Mapping(target = "password", source = "userRestoredPassword.password")
            ,@Mapping(target = "username", ignore = true)
            ,@Mapping(target = "enable", ignore = true)})
    User userRestoredPasswordToUser (UserRestoredPassword userRestoredPassword);
}
