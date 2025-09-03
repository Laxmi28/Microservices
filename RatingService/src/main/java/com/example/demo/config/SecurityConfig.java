package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true )
public class SecurityConfig {
     
    @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception{
        return security.authorizeHttpRequests(r->r.anyRequest().permitAll())
                .oauth2ResourceServer(
                    r->r.jwt()
                ).build();
     }
}
