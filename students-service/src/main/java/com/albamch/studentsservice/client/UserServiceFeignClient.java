package com.albamch.studentsservice.client;

import com.albamch.modelcommons.models.users.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "users-service")
public interface UserServiceFeignClient {

    @PostMapping("/user")
    User save (@RequestBody User user);
}
