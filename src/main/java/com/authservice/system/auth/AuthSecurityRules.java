package com.authservice.system.auth;

import com.authservice.system.common.SecurityRules;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.stereotype.Component;

@Component
public class AuthSecurityRules implements SecurityRules {
    @Override
    public void config(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
        registry.requestMatchers("/auth/login").permitAll();
        registry.requestMatchers("/auth/refresh").permitAll();
    }

}

