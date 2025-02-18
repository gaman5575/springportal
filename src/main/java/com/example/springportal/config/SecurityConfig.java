package com.example.springportal.config;

import com.example.springportal.services.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
public class SecurityConfig {

    private static final String LOGIN_URL = "/login";  // Defined constant for login URL
    private static final String HOME_URL = "/home";    // Defined constant for home URL

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.ignoringRequestMatchers("/register", LOGIN_URL)) // Ignoring csrf for certain URLs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/register", LOGIN_URL).permitAll() // Permit root, register, and login pages without authentication
                .requestMatchers("/admin/**").hasRole("ADMIN") // Restrict /admin to only users with "ADMIN" role
                .anyRequest().authenticated()  // All other requests require authentication
            )
            .formLogin(login -> login
                .loginPage(LOGIN_URL) // Custom login page URL
                .defaultSuccessUrl(HOME_URL, true)  // Redirect to home page after successful login
                .permitAll()  // Allow anyone to access the login page
            )
            .logout(logout -> logout
                .logoutUrl("/logout")  // Custom logout URL
                .logoutSuccessUrl("/login?logout")  // Redirect after successful logout
                .invalidateHttpSession(true)  // Invalidate the session after logout
                .clearAuthentication(true)  // Clear authentication after logout
                .deleteCookies("JSESSIONID")  // Delete session cookies
            );

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // BCrypt for password encoding
    }

    @Bean
    public UserDetailsService userDetailsService(UserDetailsServiceImpl userDetailsService) {
        return userDetailsService;  // Use your custom UserDetailsServiceImpl
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);  // Set custom user details service
        authProvider.setPasswordEncoder(passwordEncoder());  // Set password encoder

        return new ProviderManager(List.of(authProvider));  // Authentication manager with the provider
    }
}
