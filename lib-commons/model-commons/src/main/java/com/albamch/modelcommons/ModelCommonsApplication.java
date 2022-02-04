package com.albamch.modelcommons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ModelCommonsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelCommonsApplication.class, args);
    }

}
