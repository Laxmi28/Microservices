package com.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity){
            httpSecurity
            .authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
            .oauth2Client(withDefaults -> {})
            .oauth2ResourceServer(resourceServer -> resourceServer.jwt());

            return httpSecurity.build();
    }
}
