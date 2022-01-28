package com.albamch.jpacommons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class JpaCommonsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaCommonsApplication.class, args);
    }

}
