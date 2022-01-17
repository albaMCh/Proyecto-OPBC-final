package com.albamch.userservice.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@ComponentScan({"com.albamch.userservice.models","com.albamch.userservice.mapper","com.albamch.userservice"})
@EnableJpaRepositories("com.albamch.userservice.repository")
@EnableEurekaClient
public class SpringConfig {

    @Bean
    public BCryptPasswordEncoder cryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
