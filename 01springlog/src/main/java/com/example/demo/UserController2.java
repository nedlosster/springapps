package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/users2")
public class UserController2 {

    @Autowired
    private UserService userService;

    @PostMapping
    public String createUser(@RequestParam String username, @RequestParam String email) {
        log.debug("Received request to create user: {}", username);
        try {
            String userId = userService.createUser2(username, email);
            log.debug("Request completed successfully for user: {}", username);
            return userId;
        } catch (Exception e) {
            // log.error("Error creating user: {}", username, e);
            return "Error: " + e.getMessage();
        }
    }



}