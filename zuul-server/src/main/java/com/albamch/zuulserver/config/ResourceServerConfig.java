package com.albamch.zuulserver.config;

import com.albamch.jwtcommons.jwtConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Log4j2
@Configuration
@EnableEurekaClient
@ComponentScan({"com.albamch.zuulserver","com.albamch.modelscommons"})
@EnableZuulServer
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .anyRequest().permitAll()
                .and().cors().configurationSource(corsConfigurationSource());
    }

    // Filters

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){

        /*Aquí podemos establcer a que origen autorizamos y los sus respectivos
        * métodos, además de las cabeceras*/
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("POST","GET","PUT","DELETE","OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);

        //Aplicamos el filtro en todas las direcciones
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", configuration);

        return configurationSource;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter (){

        //Registra el cors filter
        FilterRegistrationBean<CorsFilter> filterRegistrationBean =
                new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));

        //Le damos la prioridad más alta
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);


        return filterRegistrationBean;
    }

    /*
    * Bean para verificar la firma del token
    * Se tiene que compatir entre Zuul y Authorization server para compartir los tokens
    * además incluye firma con RSA privada y pública
    * */

    @Bean
    public JwtTokenStore tokenStore(){

        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){

        //Libreria en jwt commons para zuul y auth
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey(com.albamch.jwtcommons.jwtConfig.RSA_PRIVADA);
        tokenConverter.setVerifierKey(com.albamch.jwtcommons.jwtConfig.RSA_PUBLICA);

        return tokenConverter;
    }
}