package com.albamch.userservice.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 55)
    private String username;

    @Column(unique = true, length = 110, nullable = false)
    private String email;

    @Column(nullable = false, length = 130)
    private String password;

    @Column
    private Boolean enable = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_to_roles", joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"users_id","roles_id"})})
    private List<Role> roles;

    //Setters and Getters

    public void addRoles(Role role){

        if(!this.roles.contains(role)){

            role.addUser(this);
            this.roles.add(role);
        }
    }

    public void removeRoles(Role role) {

        if (!this.roles.contains(role)) {

            role.removeUser(this);
            this.roles.remove(role);
        }
    }


}
