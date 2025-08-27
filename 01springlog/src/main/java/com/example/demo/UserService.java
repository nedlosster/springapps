package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j 
@Service
public class UserService {

    public String createUser(String username, String email) {
        log.info("Attempting to create user: {}, Email: {}", username, email);

        if ("admin".equals(username)) {
            log.warn("Attempt to create user with reserved name: {}", username);
            throw new IllegalArgumentException("Username 'admin' is reserved");
        }

        log.debug("User details validated successfully for: {}", username);

        String userId = "user_" + System.currentTimeMillis();
        log.info("User created successfully. ID: {}, Username: {}", userId, username);
        return userId;
    }


    @LogExecution 
    public String createUser2(String username, String email) {
        
        if ("admin".equals(username)) {
            log.warn("Attempt to create user with reserved name: {}", username);
            throw new IllegalArgumentException("Username 'admin' is reserved");
        }

        String userId = "user_" + System.currentTimeMillis();
        
        return userId;
    }

}