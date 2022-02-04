package com.albamch.authorizationserver.client;

import com.albamch.modelcommons.models.users.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service")
public interface UserFeignClient {

    //GET

    @GetMapping("/user/{id}")
    User findById (@PathVariable("id") Integer id);

    @PostMapping("/user/username")
    User findByUsername (@RequestParam("username") String username);

}
