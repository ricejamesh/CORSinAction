package com.example.cors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootApplication
public class CorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorsApplication.class, args);
    }

    @Bean
    public JsonNode getPost() {

        ObjectMapper objectMapper = new ObjectMapper();

        Resource resource = new ClassPathResource("/posts.json");
        try {
            JsonNode jsonNode = objectMapper.readTree(resource.getInputStream());
            return jsonNode;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
