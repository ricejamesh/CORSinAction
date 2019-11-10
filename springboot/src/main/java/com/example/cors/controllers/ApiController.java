package com.example.cors.controllers;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping(value = "posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> getPosts() {
        Resource resource = new ClassPathResource("/posts.json");

        try {
            JsonNode jsonNode = objectMapper.readTree(resource.getInputStream());
            System.out.println(jsonNode);
            return new ResponseEntity<>(jsonNode, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
