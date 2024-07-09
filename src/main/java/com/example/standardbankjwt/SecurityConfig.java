package com.example.standardbankjwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for setting up Spring Security in the application.
 * This class defines security rules and configurations for HTTP requests.
 *
 * @author Cytrogen
 * @version 1.0
 * @since 2024-07-09
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the security filter chain for the application.
     * This method sets up security rules, including CSRF protection and request authorization.
     *
     * @param http The HttpSecurity object to be configured
     * @return A SecurityFilterChain with the defined security configurations
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/authenticate").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }

}
