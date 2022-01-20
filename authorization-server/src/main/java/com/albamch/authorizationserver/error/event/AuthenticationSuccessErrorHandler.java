package com.albamch.authorizationserver.error.event;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

    @Override
    public void publishAuthenticationSuccess(Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        log.info("Succes login: " + userDetails.getUsername());
    }

    @Override
    public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {

        log.error("Error durante el login de --> " + exception.getMessage());
    }
}
