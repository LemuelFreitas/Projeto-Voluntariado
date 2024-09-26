package com.projeto.voluntariado.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests((requests) -> requests

                .requestMatchers(
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui/index.html").permitAll() // Permite acesso ao Swagger

                .requestMatchers(
                    "/voluntario/**",
                    "/organizador/**",
                    "/projeto/**").permitAll() // Somente autenticados

                .requestMatchers(
                    HttpMethod.GET, "/voluntario/", "/voluntario/{id}", "/projeto/","/projeto/{id}","/organizador/","/organizador/{id}").permitAll() // GET sem autenticação

                .requestMatchers(
                    HttpMethod.PUT, "/voluntario/{id}", "/projeto/{id}", "/organizador/{id}").permitAll() // Somente autenticados

                .requestMatchers(
                    HttpMethod.DELETE, "/voluntario/{id}", "/projeto/{id}", "/organizador/{id}").permitAll() // Somente autenticados

                .requestMatchers(
                    "/**").permitAll() // Permite todo o conteúdo da pasta static

                .anyRequest()
                .denyAll() // Nega todas as outras requisições
            )
            .httpBasic(); // Usa autenticação básica
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("voluntario")
            .password("ajuda")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
