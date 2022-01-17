package com.alba.proyectoobc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.alba.proyectoobc")
@EnableJpaRepositories("com.alba.proyectoobc.repository")
public class SpringConfig {


}
