package com.deepak.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                                .anyRequest().permitAll()
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .build();
    }
}
