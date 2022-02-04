package com.albamch.studentsservice.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.albamch.studentsservice")
@EnableJpaRepositories("com.albamch.jpacommons.repository.students")
@EntityScan("com.albamch.modelcommons.models.students")
public class SpringConfig {


}
