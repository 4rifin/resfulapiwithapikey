package org.example.restful.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new ApiKeyFilter(), org.springframework.web.filter.CorsFilter.class)  // Add API Key filter
                .authorizeHttpRequests()
                .requestMatchers("/api/**").hasRole("API_USER")  // Protect /api/** with API_USER role
                .anyRequest().permitAll()  // Allow other requests without authentication
                .and()
                .formLogin();  // Enable form-based login

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("apiuser")
                        .password("{noop}apipassword")  // Plain text for testing; use a password encoder in production
                        .roles("API_USER")
                        .build(),
                User.withUsername("admin")
                        .password("{noop}adminpassword")
                        .roles("ADMIN")
                        .build()
        );
    }


}
