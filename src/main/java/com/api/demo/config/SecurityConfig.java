package com.api.demo.config;

import com.api.demo.apikey.ApiKeyAuthFilter;
import com.api.demo.apikey.ApiKeyAuthManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by @author moya1031 on 2023-05-08
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ApiKeyAuthFilter filter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        filter.setAuthenticationManager(new ApiKeyAuthManager());
        http
                .antMatcher("/api/**")
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling();

    }
}
