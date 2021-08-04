package com.transacao.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(authorization -> authorization
                .anyRequest().authenticated())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception{
        webSecurity.ignoring()
                .antMatchers(
                   "/**.html",
                            "/swagger-ui/**",
                            "/v3/api-docs/",
                            "/webjars/**",
                            "/configuration/**",
                            "/swagger-resources/**",
                            "/swagger-ui/**",
                            "/v3/api-docs/swagger-config/**"
                );
    }
}
