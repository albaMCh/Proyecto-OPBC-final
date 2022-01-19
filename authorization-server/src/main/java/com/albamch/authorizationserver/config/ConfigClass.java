package com.albamch.authorizationserver.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaClient
@EnableFeignClients("com.albamch.authorizationserver.client")
public class ConfigClass {


}
