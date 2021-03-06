package com.albamch.fileservice.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.albamch.fileservice")
@EnableJpaRepositories("com.albamch.jpacommons.repository.files")
@EntityScan("com.albamch.modelcommons.models.files")
public class SpringConfig {


}
