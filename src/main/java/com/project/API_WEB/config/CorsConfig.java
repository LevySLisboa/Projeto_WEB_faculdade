package com.project.API_WEB.config;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Permitir solicitações de qualquer origem
        config.addAllowedMethod("*"); // Permitir solicitações de qualquer método (GET, POST, etc.)
        config.addAllowedHeader("*"); // Permitir solicitações com qualquer cabeçalho
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

