package com.yasu.ccsapi.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyAuthManager implements AuthenticationManager {

    private final String TEST = "test";
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("키 확인 코드");
        String principal = (String) authentication.getPrincipal();
        if (!TEST.equals(principal)) {
            throw new BadCredentialsException("The API key was not found or not the expected value.");
        }
        authentication.setAuthenticated(true);
        return authentication;
    }
}
