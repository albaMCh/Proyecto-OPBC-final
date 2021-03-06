package com.albamch.userservice.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@ComponentScan({"com.albamch.userservice.mapper","com.albamch.userservice","com.albamch.errors"})
@EnableJpaRepositories("com.albamch.jpacommons.repository.users")
@EntityScan("com.albamch.modelcommons.models.users")
@EnableEurekaClient
public class SpringConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder (){

        return new BCryptPasswordEncoder();
    }
}
