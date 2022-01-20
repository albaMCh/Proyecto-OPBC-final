package com.albamch.authorizationserver.service;

import com.albamch.authorizationserver.client.UserFeignClient;
import com.albamch.modelscommons.models.users.User;
import feign.FeignException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class UserService implements UserDetailsService, IUserService {

    private UserFeignClient userFeignClient;

    @Autowired
    public UserService(UserFeignClient userFeignClient) {

        this.userFeignClient = userFeignClient;
    }

    @Override
    public User findByUsername(String name) {

        return userFeignClient.findByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {

            User user = findByUsername(username);

            List<GrantedAuthority> authorities = user.getRoles()
                    .stream()
                    .map(roles -> new SimpleGrantedAuthority(roles.getName()))
                    .peek(authority -> log.info("Role: " + authority))
                    .collect(Collectors.toList());
        }

        catch (FeignException e) {

            String error = "No existe el usuario: " + username;
            log.error(error);
            e.printStackTrace();
        }

        return null;
    }
}
