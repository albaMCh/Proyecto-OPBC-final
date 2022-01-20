package com.albamch.authorizationserver.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaClient
@ComponentScan("com.albamch.authorizationserver")
@EnableFeignClients("com.albamch.authorizationserver.client")
public class ConfigClass {


}
