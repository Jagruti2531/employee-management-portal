package com.employeeportal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http,
            JwtFilter jwt) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .cors(cors -> {
                // CORS handled by global CorsFilter
            })

            .sessionManagement(session ->
                session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS
                )
            )

            .authorizeHttpRequests(auth -> auth

                // CORS preflight
                .requestMatchers(
                    HttpMethod.OPTIONS,
                    "/**"
                ).permitAll()

                // Login / signup
                .requestMatchers(
                    "/api/auth/**"
                ).permitAll()

                // HR
                .requestMatchers(
                    "/api/hr/**"
                ).hasRole("HR")

                // Manager
                .requestMatchers(
                    "/api/manager/**"
                ).hasAnyRole(
                    "MANAGER",
                    "HR",
                    "ADMIN"
                )

                // Admin
                .requestMatchers(
                    "/api/admin/**"
                ).hasRole("ADMIN")

                // Everything else requires login
                .anyRequest().authenticated()
            )

            .addFilterBefore(
                jwt,
                UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }
}