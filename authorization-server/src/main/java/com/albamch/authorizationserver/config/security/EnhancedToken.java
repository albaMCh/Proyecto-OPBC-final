package com.albamch.authorizationserver.config.security;

import com.albamch.authorizationserver.service.IUserService;
import com.albamch.modelscommons.models.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EnhancedToken implements TokenEnhancer {

    private IUserService iUserService;

    @Autowired
    public EnhancedToken(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    /*Añadimos información extra al token para su posterior uso*/

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        Map<String, Object> tokenInfo = new HashMap<>();

        User user = iUserService.findByUsername(oAuth2Authentication.getName());

        tokenInfo.put("name", user.getName());
        tokenInfo.put("lastname", user.getLastname());
        tokenInfo.put("email", user.getEmail());

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(tokenInfo);

        return oAuth2AccessToken;
    }
}
