package com.spring.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(auth -> auth

                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                .requestMatchers("/auth/**").permitAll()

                // Public GET APIs
                .requestMatchers(HttpMethod.GET,
                        "/regions",
                        "/regions/**",
                        "/projects",
                        "/projects/**",
                        "/properties",
                        "/properties/**",
                        "/users/managers")
                .permitAll()

                // Public Lead Creation
                .requestMatchers(HttpMethod.POST, "/leads")
                .permitAll()
                
                .requestMatchers(
                        HttpMethod.GET,
                        "/users/agents")
                .hasAnyRole("ADMIN", "MANAGER")
                // Admin APIs
                .requestMatchers("/users/**")
                .hasRole("ADMIN")

                // Admin & Manager APIs
                .requestMatchers(
                        HttpMethod.PUT,
                        "/leads/*/assign",
                        "/leads/*/assign-to/*")
                .hasAnyRole("ADMIN", "MANAGER")

                .requestMatchers("/reports/**")
                .hasAnyRole("ADMIN", "MANAGER")

                // Admin, Manager, Agent APIs
                .requestMatchers(
                        "/followups/**",
                        "/site-visits/**",
                        "/leads/**")
                .hasAnyRole("ADMIN", "MANAGER", "AGENT")

                .anyRequest().authenticated()
            )
            .addFilterBefore(
                    jwtAuthenticationFilter,
                    UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(
                List.of("http://localhost:3000"));

        configuration.setAllowedMethods(
                List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        configuration.setAllowedHeaders(List.of("*"));

        configuration.setExposedHeaders(
                List.of("Authorization", "Content-Disposition"));

        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}