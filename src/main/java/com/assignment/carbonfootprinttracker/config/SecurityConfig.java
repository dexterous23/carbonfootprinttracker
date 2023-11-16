package com.assignment.carbonfootprinttracker.config;

import com.assignment.carbonfootprinttracker.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    public SecurityConfig(PasswordEncoder passwordEncoder) {
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/registration", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") // custom login page, if you have one
                .defaultSuccessUrl("/", true) // redirect after successful login
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout") // page to redirect to after logout
                .permitAll();

        return http.build();
    }

    // ... (other beans like PasswordEncoder)
}