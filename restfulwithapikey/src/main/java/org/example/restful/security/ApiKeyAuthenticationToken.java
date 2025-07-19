package org.example.restful.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

/**
 * Create Custom Authentication Token
 */
public class ApiKeyAuthenticationToken extends AbstractAuthenticationToken {

    private String apiKey;
    public ApiKeyAuthenticationToken(String apiKey) {
        super(Collections.singletonList(new SimpleGrantedAuthority("ROLE_API_USER")));
        this.apiKey = apiKey;
        setAuthenticated(true);
    }
    @Override
    public Object getCredentials() {
        return apiKey;
    }

    @Override
    public Object getPrincipal() {
        return apiKey;
    }
}
