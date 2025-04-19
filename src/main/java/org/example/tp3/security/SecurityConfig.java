package org.example.tp3.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user").password(passwordEncoder.encode("password")).roles("USER").build(),
                User.withUsername("youssef").password(passwordEncoder.encode("password1")).roles("USER").build(),
                User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("ADMIN").build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.formLogin(withDefaults());
        httpSecurity.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests.requestMatchers("/user/**").hasRole("USER"));
        httpSecurity.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests.requestMatchers("/admin/**").hasRole("ADMIN"));
         httpSecurity.authorizeHttpRequests(authorizeRequests ->
                    authorizeRequests.anyRequest().authenticated());
    return httpSecurity.build();
    }
}
