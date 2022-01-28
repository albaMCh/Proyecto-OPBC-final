package com.albamch.modelscommons.models.jwt;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserToken {

    private String lastname;
    private List<String> scopes;
    private String name;
    private Integer exp;
    private List<String> authorities;
    private String jti;
    private String email;
    private String client_id;
}