package com.albamch.userservice.DAO;

import lombok.Data;

@Data
public class UserRestoredPassword {

    private Integer id;
    private String email;
    private String password;

}