package com.authservice.system.client;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            var authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null) {
                // If you’re using UsernamePasswordAuthenticationToken
                String token = authentication.getCredentials().toString();
                requestTemplate.header("Authorization", "Bearer " + token);
            }
        };
    }
}
