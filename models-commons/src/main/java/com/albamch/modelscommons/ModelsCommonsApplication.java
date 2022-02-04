package com.albamch.modelscommons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ModelsCommonsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelsCommonsApplication.class, args);
    }

}
