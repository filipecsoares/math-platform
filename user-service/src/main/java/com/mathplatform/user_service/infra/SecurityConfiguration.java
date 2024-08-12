package com.mathplatform.user_service.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private static final String[] AUTH_WHITELIST = {
            "/api/v1/users/ping",
            "/api/v1/users/register",
            "/api/v1/users/login",
            "/h2-console/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(AUTH_WHITELIST).permitAll()
                .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
