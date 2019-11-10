package com.example.cors.config;

import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@ConfigurationProperties(prefix = "global")
@Data
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private CorsSettings corsSettings;

    @Data
    public static class CorsSettings {
        private List<String> allowedOrigins;
        private List<String> allowedMethods;
        private String registeredPath;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        System.out.println(corsSettings.toString());
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(corsSettings.allowedOrigins);
        configuration.setAllowedMethods(corsSettings.allowedMethods);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(corsSettings.registeredPath, configuration);
        return source;
    }
}
