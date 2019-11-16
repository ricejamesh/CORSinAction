package com.example.cors.controllers;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    JsonNode posts;

    @GetMapping(value = "posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> getPosts() {
        if (posts != null) {
            System.out.println(posts);
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "posts/yo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> getYo() {
        if (posts != null) {
            System.out.println("YO YO YO");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> deletePost(@PathVariable("id") String id) {
        System.out.println("--- HERE ---");
        if (posts instanceof ObjectNode) {
            ObjectNode postList = (ObjectNode) posts;
            postList.remove(id);
            System.out.println(posts);
            return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
        } else {
            System.out.println("Something didn't work.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "posts/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> deleteExample() {
        System.out.println("--- DELETE EXAMPLE ---");
        return new ResponseEntity<>("Delete Example", HttpStatus.NO_CONTENT);
    }
}
