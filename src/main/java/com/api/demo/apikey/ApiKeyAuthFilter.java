package com.api.demo.apikey;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by @author moya1031 on 2023-05-08
 */
@Component
public class ApiKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

    private String API_KEY_AUTH_HEADER_NAME = "Authentication";

    @Autowired
    public ApiKeyAuthFilter(ApiKeyAuthManager manager) {
        this.setAuthenticationManager(manager);
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return request.getHeader(API_KEY_AUTH_HEADER_NAME);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "N/A";
    }
}
