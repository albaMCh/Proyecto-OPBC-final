package com.albamch.modelcommons.models.jwt;

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

    //

    @Override
    public String toString() {
        return "UserToken{" +
                "lastname='" + lastname + '\'' +
                ", scopes=" + scopes +
                ", name='" + name + '\'' +
                ", exp=" + exp +
                ", authorities=" + authorities +
                ", jti='" + jti + '\'' +
                ", email='" + email + '\'' +
                ", client_id='" + client_id + '\'' +
                '}';
    }
}
