package com.ticket.ticket_backend.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private String[] PUBLIC_ROLES = {
            "/roles",
            "/roles/create",
            "/roles/update/*",
            "/roles/delete/*"
    };

    private String[] PUBLIC_PERMISSIONS = {
            "/permissions",
            "/permissions/create",
            "/permissions/update/*",
            "/permissions/delete/*",
            "/permissions/*"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeHttpRequests(req -> req
                        .requestMatchers(PUBLIC_ROLES).permitAll()
                        .requestMatchers(PUBLIC_PERMISSIONS).permitAll()
//                        .requestMatchers("").permitAll()
                        .anyRequest().authenticated()
                )

                .csrf(AbstractHttpConfigurer::disable);


        return httpSecurity.build();
    }

}
