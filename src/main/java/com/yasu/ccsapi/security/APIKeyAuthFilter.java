package com.yasu.ccsapi.security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class APIKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {
    private String principalRequestHeader;

    @Autowired
    public APIKeyAuthFilter(ApiKeyAuthManager manager) {
        this.setAuthenticationManager(manager);
    }

    public APIKeyAuthFilter(String principalRequestHeader) {
        this.principalRequestHeader = principalRequestHeader;
    }
    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return request.getHeader(principalRequestHeader);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "N/A";
    }
}
